package com.backendprojektweb.service;

import com.backendprojektweb.model.Movie;
import com.backendprojektweb.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository repository;

    public List<Movie> getMovies() { return repository.findAll(); }

    public Movie getMovie(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Movie saveMovie(Movie movie) {
        return repository.save(movie);
    }
}
