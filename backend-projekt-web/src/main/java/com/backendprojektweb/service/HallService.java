package com.backendprojektweb.service;

import com.backendprojektweb.model.Hall;
import com.backendprojektweb.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HallService {
    @Autowired
    HallRepository repository;

    public List<Hall> getHalls() {
        List<Hall> result = repository.findAll();
        if(result.size() <= 0) {
            result = new ArrayList<Hall>();
        }
        return result;
    }

    public Hall getHall(Integer id) {
        Hall result = null;
        Optional<Hall> foundHall = repository.findById(id);
        if(foundHall.isPresent()) {
            result = foundHall.get();
        }
        return result;
    }

    public Hall updateHall(Hall hall) {
        Hall result;
        Optional<Hall> foundHall = repository.findById(hall.getId());
        if(foundHall.isPresent()) {
            result = foundHall.get();
        }
        result = repository.save(hall);
        return result;
    }
}
