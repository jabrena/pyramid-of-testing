package org.jab.fundamentals.controller;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jab.fundamentals.service.TokenService.TOKEN_LENGTH;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TokenControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Tag("integration")
    @Test
    public void given() {

        ResponseEntity<MyResponse> response = restTemplate.
                getForEntity(createURLWithPort("/token"), MyResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getToken().length()).isEqualTo(TOKEN_LENGTH);
    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}