package com.backendprojektweb.api;

import com.backendprojektweb.model.ReservationSeat;
import com.backendprojektweb.service.ReservationSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation_seats")
public class ReservationSeatController {
    @Autowired
    ReservationSeatService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ReservationSeat>> getReservationSeats() {
        List<ReservationSeat> reservationSeats = service.getReservationSeats();
        return new ResponseEntity<List<ReservationSeat>>(reservationSeats, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReservationSeat> updateReservationSeat(@RequestBody ReservationSeat reservationSeat) {
        ReservationSeat newReservationSeat = service.updateReservationSeat(reservationSeat);
        return new ResponseEntity<ReservationSeat>(newReservationSeat, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationSeat> getReservationSeat(@PathVariable("id") Integer id) {
        ReservationSeat reservationSeat = service.getReservationSeat(id);
        return new ResponseEntity<ReservationSeat>(reservationSeat, new HttpHeaders(), HttpStatus.OK);
    }
}
