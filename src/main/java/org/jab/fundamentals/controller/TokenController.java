package org.jab.fundamentals.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jab.fundamentals.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class TokenController {

    private TokenService demoService;

    @GetMapping("/token")
    public ResponseEntity<MyResponse> getToken() {

        LOGGER.trace("Executing endpoint /token");

        return new ResponseEntity<>(
                new MyResponse(demoService.getToken()),
                HttpStatus.OK);
    }

}
