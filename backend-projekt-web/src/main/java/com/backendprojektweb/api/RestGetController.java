package com.backendprojektweb.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestGetController {

    @GetMapping(path = "/get", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getRequest() {
        return "Placeholder Get";
    }
}
