package com.backendprojektweb.api;

import com.backendprojektweb.model.Seat;
import com.backendprojektweb.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {
    @Autowired
    SeatService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Seat>> getSeats() {
        List<Seat> seats = service.getSeats();
        return new ResponseEntity<List<Seat>>(seats, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Seat> updateSeat(@RequestBody Seat seat) {
        Seat newSeat = service.updateSeat(seat);
        return new ResponseEntity<Seat>(newSeat, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeat(@PathVariable("id") Integer id) {
        Seat seat = service.getSeat(id);
        return new ResponseEntity<Seat>(seat, new HttpHeaders(), HttpStatus.OK);
    }
}
