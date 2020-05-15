package com.backendprojektweb.api;

import com.backendprojektweb.model.Reservation;
import com.backendprojektweb.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    ReservationService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Reservation>> getReservations() {
        List<Reservation> reservations = service.getReservations();
        return new ResponseEntity<List<Reservation>>(reservations, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
        Reservation newReservation = service.updateReservation(reservation);
        return new ResponseEntity<Reservation>(newReservation, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable("id") Integer id) {
        Reservation reservation = service.getReservation(id);
        return new ResponseEntity<Reservation>(reservation, new HttpHeaders(), HttpStatus.OK);
    }
}
