package com.tutorial.tailerbox.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class RouteConfigProviderTest {

    @Value("${routes.api-base-uri}")
    private String apiBaseUri;

    @Value("${routes.api-version}")
    private String apiVersion;

    @Test
    public void getApiRoute() {
        log.info("***************************** Start RouteConfig Test *****************************");
        assertNotNull(apiBaseUri, "route.api-base-uri is not set.");
        assertNotNull(apiVersion, "route.api-version is not set.");
        log.info("***************************** End   RouteConfig Test *****************************");
    }
}