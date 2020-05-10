package com.backendprojektweb.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestPutController {

    @PutMapping(path = "/put", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String putRequest(@RequestBody String testString) {
        return  "Placeholder Put";
    }

}
