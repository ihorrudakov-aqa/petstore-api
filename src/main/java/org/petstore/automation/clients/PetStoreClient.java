package org.petstore.automation.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.petstore.automation.config.TestConfig;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

@Getter
@Slf4j
public class PetStoreClient {

    private final RequestSpecBuilder builder;

    public PetStoreClient() {
        builder = new RequestSpecBuilder();
        log.debug("Creating client with baseUrl {}", TestConfig.baseUrl);
        builder.setBaseUri(TestConfig.baseUrl).setRelaxedHTTPSValidation()
                .setContentType(ContentType.JSON);
    }
}
