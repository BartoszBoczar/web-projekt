package com.backendprojektweb.api;

import com.backendprojektweb.model.ReservationSeat;
import com.backendprojektweb.service.ReservationSeatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation_seats")
@AllArgsConstructor
public class ReservationSeatController {
    private final ReservationSeatService service;

    @GetMapping("/{id}")
    public ResponseEntity<ReservationSeat> getReservationSeat(@PathVariable("id") Long id) {
        ReservationSeat reservationSeat = service.getReservationSeat(id);
        return new ResponseEntity<>(reservationSeat, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ReservationSeat>> getReservationSeats() {
        List<ReservationSeat> reservationSeats = service.getReservationSeats();
        return new ResponseEntity<>(reservationSeats, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReservationSeat> saveReservationSeat(@RequestBody ReservationSeat reservationSeat) {
        ReservationSeat newReservationSeat = service.saveReservationSeat(reservationSeat);
        return new ResponseEntity<>(newReservationSeat, new HttpHeaders(), HttpStatus.OK);
    }
}
