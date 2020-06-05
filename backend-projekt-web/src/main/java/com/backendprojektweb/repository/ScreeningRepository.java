package com.backendprojektweb.repository;

import com.backendprojektweb.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    @Query(value = "SELECT sc " +
            "FROM #{#entityName} sc " +
            "JOIN sc.movieId m " +
            "WHERE m.id = :movieId")
    public List<Screening> allScreeningsOfMovie(@Param("movieId") Long movieId);
}
