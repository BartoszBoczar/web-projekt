package com.backendprojektweb.api;

import com.backendprojektweb.exceptions.ReferenceNotPresentException;
import com.backendprojektweb.model.Seat;
import com.backendprojektweb.model.dto.SeatDTO;
import com.backendprojektweb.service.SeatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
@AllArgsConstructor
public class SeatController {
    private final SeatService service;

    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeat(@PathVariable("id") Long id) {
        Seat seat = service.getSeat(id);
        return new ResponseEntity<>(seat, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Seat>> getSeats() {
        List<Seat> seats = service.getSeats();
        return new ResponseEntity<>(seats, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Seat> saveSeat(@RequestBody SeatDTO seatDTO) {
        Seat newSeat;
        try {
            newSeat = service.saveSeat(seatDTO);
        } catch (ReferenceNotPresentException e) {
            newSeat = null;
        }
        return new ResponseEntity<>(newSeat, new HttpHeaders(), HttpStatus.OK);
    }
}
