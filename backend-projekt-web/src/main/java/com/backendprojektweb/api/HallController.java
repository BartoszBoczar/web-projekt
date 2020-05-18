package com.backendprojektweb.api;

import com.backendprojektweb.model.Hall;
import com.backendprojektweb.service.HallService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/halls")
@AllArgsConstructor
public class HallController {
    private final HallService service;

    @GetMapping("/{id}")
    public ResponseEntity<Hall> getHall(@PathVariable("id") Long id) {
        Hall hall = service.getHall(id);
        return new ResponseEntity<>(hall, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Hall>> getHalls() {
        List<Hall> halls = service.getHalls();
        return new ResponseEntity<>(halls, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Hall> saveHall(@RequestBody Hall hall) {
        Hall newHall = service.saveHall(hall);
        return new ResponseEntity<>(newHall, new HttpHeaders(), HttpStatus.OK);
    }
}
