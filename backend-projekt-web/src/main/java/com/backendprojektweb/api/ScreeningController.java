package com.backendprojektweb.api;

import com.backendprojektweb.model.Screening;
import com.backendprojektweb.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screenings")
public class ScreeningController {
    @Autowired
    ScreeningService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Screening>> getScreenings() {
        List<Screening> screenings = service.getScreenings();
        return new ResponseEntity<List<Screening>>(screenings, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Screening> updateScreening(@RequestBody Screening screening) {
        Screening newScreening = service.updateScreening(screening);
        return new ResponseEntity<Screening>(newScreening, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screening> getScreening(@PathVariable("id") Integer id) {
        Screening screening = service.getScreening(id);
        return new ResponseEntity<Screening>(screening, new HttpHeaders(), HttpStatus.OK);
    }
}
