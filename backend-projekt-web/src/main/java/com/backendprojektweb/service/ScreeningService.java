package com.backendprojektweb.service;

import com.backendprojektweb.model.Screening;
import com.backendprojektweb.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScreeningService {
    @Autowired
    ScreeningRepository repository;

    public List<Screening> getScreenings() {
        List<Screening> result = repository.findAll();
        if(result.size() <= 0) {
            result = new ArrayList<Screening>();
        }
        return result;
    }

    public Screening getScreening(Integer id) {
        Screening result = null;
        Optional<Screening> foundScreening = repository.findById(id);
        if(foundScreening.isPresent()) {
            result = foundScreening.get();
        }
        return result;
    }

    public Screening updateScreening(Screening screening) {
        Screening result;
        Optional<Screening> foundScreening = repository.findById(screening.getId());
        if(foundScreening.isPresent()) {
            result = foundScreening.get();
            result.setMovieId(screening.getMovieId());
            result.setHallId(screening.getHallId());
            result.setPrice(screening.getPrice());
            result.setTime(screening.getTime());
        }
        result = repository.save(screening);
        return result;
    }
}
