package org.petstore.automation.holders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.petstore.automation.clients.PetStoreClient;
import org.petstore.automation.config.TestConfig;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.asynchttpclient.util.HttpConstants.Methods.*;

@Slf4j
public class PetStoreClientHolder {

    @Getter
    RequestSpecBuilder builder;

    public ResponseOptions<Response> executeAPI(String method, String path) {
        return executeAPI(TestConfig.baseUrl, method, path);
    }

    public ResponseOptions<Response> executeAPI(String url, String method, String path) {
        builder = new PetStoreClient().getBuilder();
        builder.setBaseUri(url);

        log.debug("Sending {} to {}{}", method, TestConfig.baseUrl, path);
        if (method.equalsIgnoreCase(GET)) {
            return given().spec(getSpec()).get(path);
        }  else if (method.equalsIgnoreCase(DELETE)) {
            return given().spec(getSpec()).delete(path);
        } else {
            return null;
        }
    }

    public ResponseOptions<Response> executeAPIWithPayload(String method, String path, Object body) {
        return executeAPIWithPayload(TestConfig.baseUrl, method, path, body);
    }

    public ResponseOptions<Response> executeAPIWithPayload(String url, String method, String path, Object body) {
        builder = new PetStoreClient().getBuilder();
        builder.setBaseUri(url);

        log.debug("Sending {} to {}{} with body {}", method, TestConfig.baseUrl, path, body);
        if (method.equalsIgnoreCase(POST)) {
            return given().spec(getSpec(body)).post(path);
        }  else if (method.equalsIgnoreCase(PUT)) {
            return given().spec(getSpec(body)).put(path);
        } else {
            return null;
        }
    }

    private RequestSpecification getSpec(Object body) {
        return getBuilder().setBody(body).addHeaders(
                Map.of("Authorization", "Bearer {token}")
        ).build();
    }

    private RequestSpecification getSpec() {
        return getBuilder().build();
    }
}
