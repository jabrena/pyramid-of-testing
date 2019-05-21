package org.jab.fundamentals.service;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jab.fundamentals.service.TokenService.TOKEN_LENGTH;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TokenServiceTest {

    @Autowired
    private TokenService tokenService;

    @Tag("unit")
    @Test
    public void demoTest(){

        assertThat(tokenService.getToken().length()).isEqualTo(TOKEN_LENGTH);
    }

}