package com.backendprojektweb.api;

import com.backendprojektweb.model.Movie;
import com.backendprojektweb.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {
    private final MovieService service;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Long id) {
        Movie movie = service.getMovie(id);
        return new ResponseEntity<>(movie, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = service.getMovies();
        return new ResponseEntity<>(movies, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        Movie newMovie = service.saveMovie(movie);
        return new ResponseEntity<>(newMovie, new HttpHeaders(), HttpStatus.OK);
    }
}
