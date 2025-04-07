package org.petstore.automation;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.petstore.automation.dto.OrderRequestResponse;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.asynchttpclient.util.HttpConstants.Methods.GET;
import static org.asynchttpclient.util.HttpConstants.Methods.POST;

public class PetStorePositiveTest extends BaseTest {

    @Test(description = "Verify that GET /inventory returns status 200 and has numbers for all the props",
            groups = {"api", "store", "positive"})
    public void getInventoryTest() {
        ResponseOptions<Response> response = service.executeAPI(GET, "/v2/store/inventory");
        assertThat(response.statusCode()).isEqualTo(200);
        Map<String, Integer> data = response.getBody().jsonPath().getMap("");
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            assertThat(entry.getValue()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test(description = "Verify that POST /order with completed status returns status 200 and has the same response as request",
            groups = {"api", "store", "positive"})
    public void createOrderWithCompleteStatusTest() {
        OrderRequestResponse orderRequestResponse = td.orderTestData.getCompletedValidOrder();
        ResponseOptions<Response> response = service.executeAPIWithPayload(POST, "/v2/store/order", orderRequestResponse);
        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.getBody().as(OrderRequestResponse.class)).isEqualTo(orderRequestResponse);
    }

    @Test(description = "Verify that POST /order with incomplete status returns status 200 and has the same response as request",
            groups = {"api", "store", "positive"})
    public void createOrderWithIncompleteStatusTest() {
        OrderRequestResponse orderRequestResponse = td.orderTestData.getIncompleteValidOrder();
        ResponseOptions<Response> response = service.executeAPIWithPayload(POST, "/v2/store/order", orderRequestResponse);
        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.getBody().as(OrderRequestResponse.class)).isEqualTo(orderRequestResponse);
    }

    @Test(description = "Verify that GET /order returns status 200, match contract and has correct id in the payload",
            groups = {"api", "store", "positive"})
    public void getOrderTest() {
        int orderId = new Random().nextInt(1, 5);
        ResponseOptions<Response> response = service.executeAPI(GET, "/v2/store/order/" + orderId);
        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.getBody().as(OrderRequestResponse.class).getId()).isEqualTo(orderId);
    }

    @Test(description = "Verify that DELETE /order returns status 200, match contract and has correct id in the payload",
            groups = {"api", "store", "positive"})
    public void deleteOrderTest() {
        int orderId = new Random().nextInt(1, 5);
        ResponseOptions<Response> response = service.executeAPI(GET, "/v2/store/order/" + orderId);
        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.getBody().as(OrderRequestResponse.class).getId()).isEqualTo(orderId);
    }

}


