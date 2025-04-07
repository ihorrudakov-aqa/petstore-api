package org.petstore.automation;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.petstore.automation.dto.OrderRequestResponse;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.asynchttpclient.util.HttpConstants.Methods.*;

public class PetStoreNegativeTest extends BaseTest {

    @Test(description = "Verify that POST /order with empty petId returns status 404",
            groups = {"api", "store", "negative"})
    public void createOrderWithEmptyPetIdTest() {
        OrderRequestResponse orderRequestResponse = td.orderTestData.getInvalidOrderWithNoPetId();
        ResponseOptions<Response> response = service.executeAPIWithPayload(POST, "/store/order", orderRequestResponse);
        assertThat(response.statusCode()).isEqualTo(404);
    }

    @Test(description = "Verify that POST /order with empty id returns status 404",
            groups = {"api", "store", "negative"})
    public void createOrderWithIncorrectDateFormatTest() {
        OrderRequestResponse orderRequestResponse = td.orderTestData.getInvalidOrderWithNoId();
        ResponseOptions<Response> response = service.executeAPIWithPayload(POST, "/store/order", orderRequestResponse);
        assertThat(response.statusCode()).isEqualTo(404);
    }

    @Test(description = "Verify that GET /order with id = 0 returns status 404",
            groups = {"api", "store", "negative"})
    public void getOrderTest() {
        ResponseOptions<Response> response = service.executeAPI(GET, "/store/order/0");
        assertThat(response.statusCode()).isEqualTo(404);
    }

    @Test(description = "Verify that DELETE /order with id = 0 returns status 404",
            groups = {"api", "store", "negative"})
    public void deleteOrderTest() {
        ResponseOptions<Response> response = service.executeAPI(DELETE, "/store/order/0");
        assertThat(response.statusCode()).isEqualTo(405);
    }

}


