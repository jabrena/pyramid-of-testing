package org.fundamentals.testing.controller;

import lombok.extern.slf4j.Slf4j;
import org.fundamentals.testing.model.ResponseDemo;
import org.fundamentals.testing.service.DemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DemoEndpoint {

    private DemoService demoService;

    public DemoEndpoint(final DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/demo")
    public ResponseEntity<?> executeDemoEndpoint() {

        LOGGER.trace("Executing endpoint /demo");

        final ResponseDemo result = new ResponseDemo(demoService.getToken().getCharacters());
        final HttpStatus status = HttpStatus.OK;

        return new ResponseEntity<>(result, status);
    }

}
