package com.backendprojektweb.api;

import com.backendprojektweb.exceptions.ReferenceNotPresentException;
import com.backendprojektweb.model.Screening;
import com.backendprojektweb.model.dto.ScreeningDTO;
import com.backendprojektweb.service.ScreeningService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screenings")
@AllArgsConstructor
public class ScreeningController {
    private final ScreeningService service;

    @GetMapping("/{id}")
    public ResponseEntity<Screening> getScreening(@PathVariable("id") Long id) {
        Screening screening = service.getScreening(id);
        return new ResponseEntity<>(screening, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/movie/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Screening>> getScreeningOfMovie(@PathVariable("id") Long id) {
        List<Screening> screening = service.getScreeningsOfMovie(id);
        return new ResponseEntity<>(screening, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/movieFromNow/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Screening>> getScreeningOfMovieFromNow(@PathVariable("id") Long id) {
        List<Screening> screening = service.getScreeningsOfMovieFromNow(id);
        return new ResponseEntity<>(screening, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Screening>> getScreenings() {
        List<Screening> screenings = service.getScreenings();
        return new ResponseEntity<>(screenings, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Screening> saveScreening(@RequestBody ScreeningDTO screeningDTO) {
        Screening newScreening;
        try {
            newScreening = service.saveScreening(screeningDTO);
        } catch (ReferenceNotPresentException e) {
            newScreening = null;
        }
        return new ResponseEntity<>(newScreening, new HttpHeaders(), HttpStatus.OK);
    }
}
