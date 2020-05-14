package com.backendprojektweb.api;

import com.backendprojektweb.model.Movie;
import com.backendprojektweb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = service.getMovies();
        return new ResponseEntity<List<Movie>>(movies, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        Movie newMovie = service.updateMovie(movie);
        return new ResponseEntity<Movie>(newMovie, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Integer id) {
        Movie movie = service.getMovie(id);
        return new ResponseEntity<Movie>(movie, new HttpHeaders(), HttpStatus.OK);
    }
}
