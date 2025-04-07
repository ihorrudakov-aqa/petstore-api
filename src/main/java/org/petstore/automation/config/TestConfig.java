package org.petstore.automation.config;

import lombok.extern.slf4j.Slf4j;

import static java.lang.System.getProperty;

@Slf4j
public class TestConfig {

    public static String environment = getProperty("environment", "dev");

    public static String baseUrl = getProperty("baseUrl", "https://petstore.swagger.io");

}
