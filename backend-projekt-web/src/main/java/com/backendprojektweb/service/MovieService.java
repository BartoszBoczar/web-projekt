package com.backendprojektweb.service;

import com.backendprojektweb.model.Movie;
import com.backendprojektweb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository repository;

    public List<Movie> getMovies() {
        List<Movie> result = repository.findAll();
        if(result.size() <= 0) {
            result = new ArrayList<Movie>();
        }
        return result;
    }

    public Movie getMovie(Integer id) {
        Movie result = null;
        Optional<Movie> foundMovie = repository.findById(id);
        if(foundMovie.isPresent()) {
            result = foundMovie.get();
        }
        return result;
    }

    public Movie updateMovie(Movie movie) {
        Movie result;
        Optional<Movie> foundMovie = repository.findById(movie.getId());
        if(foundMovie.isPresent()) {
            result = foundMovie.get();
            result.setTitle(movie.getTitle());
            result.setDescription(movie.getDescription());
            result.setDuration(movie.getDuration());
            result.setImage(movie.getImage());
        }
        result = repository.save(movie);
        return result;
    }
}
