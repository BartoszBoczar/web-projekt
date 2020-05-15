package com.backendprojektweb.api;

import com.backendprojektweb.model.Hall;
import com.backendprojektweb.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/halls")
public class HallController {
    @Autowired
    HallService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Hall>> getHalls() {
        List<Hall> halls = service.getHalls();
        return new ResponseEntity<List<Hall>>(halls, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Hall> updateHall(@RequestBody Hall hall) {
        Hall newHall = service.updateHall(hall);
        return new ResponseEntity<Hall>(newHall, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hall> getHall(@PathVariable("id") Integer id) {
        Hall hall = service.getHall(id);
        return new ResponseEntity<Hall>(hall, new HttpHeaders(), HttpStatus.OK);
    }
}
