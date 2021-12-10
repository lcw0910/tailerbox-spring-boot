package com.tutorial.tailerbox;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
class TailerboxApplicationTests {

    @Value("${routes.api-base-uri:/api}")
    private String apiBaseUri;

    @Value("${routes.api-version:1}")
    private String apiVersion;

    @Autowired
    private Environment environment;

    @Test
    void testRouteConfigVariables() {

        String apiBaseUriByEnv = environment.getProperty("routes.api-base-uri");
        String apiBaseVersionByEnv = environment.getProperty("routes.api-version");

        assertNotNull(apiBaseUriByEnv, "The required environmental variable has not been set. [route.api-base-uri]");
        assertNotNull(apiBaseVersionByEnv, "The required environmental variable has not been set. [route.api-version]");

        HashMap<String, String> expected = new HashMap<>();
        expected.put("apiBaseUri", apiBaseUri);
        expected.put("apiVersion", apiVersion);

        HashMap<String, String> actual = new HashMap<>();
        actual.put("apiBaseUri", apiBaseUriByEnv);
        actual.put("apiVersion", apiBaseVersionByEnv);

        assertEquals(expected, actual, "The set environment variable does not match the expected value.");

    }

}
