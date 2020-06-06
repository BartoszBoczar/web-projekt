package com.backendprojektweb.api;

import com.backendprojektweb.model.Reservation;
import com.backendprojektweb.model.dto.ReservationDTO;
import com.backendprojektweb.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {
    private final ReservationService service;

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable("id") Long id) {
        Reservation reservation = service.getReservation(id);
        return new ResponseEntity<>(reservation, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Reservation>> getReservations() {
        List<Reservation> reservations = service.getReservations();
        return new ResponseEntity<>(reservations, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Reservation> saveReservation(@RequestBody ReservationDTO reservationDTO) {
        Reservation newReservation = service.saveReservation(reservationDTO);
        return new ResponseEntity<>(newReservation, new HttpHeaders(), HttpStatus.OK);
    }
}
