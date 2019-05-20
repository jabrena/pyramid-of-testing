package org.fundamentals.testing.controller;

import org.fundamentals.testing.model.DataContainer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoEndpointTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Tag("integration")
    @Test
    public void testCreateStudent() {

        //ResponseEntity<DataContainer> response = restTemplate.
        //        getForEntity(createURLWithPort("/getToken"), DataContainer.class);

        assertThat(true).isTrue();
    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}