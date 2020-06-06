package com.backendprojektweb.repository;

import com.backendprojektweb.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    @Query(value = "SELECT sc " +
            "FROM #{#entityName} sc " +
            "JOIN sc.movieId m " +
            "WHERE m.id = :movieId")
    public List<Screening> allScreeningsOfMovie(@Param("movieId") Long movieId);
    @Query(value = "SELECT sc " +
            "FROM #{#entityName} sc " +
            "JOIN sc.movieId m " +
            "WHERE m.id = :movieId " +
            "AND sc.time >= :dateFrom " +
            "ORDER BY sc.time ASC")
    public List<Screening> allScreeningsOfMovieFromDate(@Param("movieId") Long movieId, @Param("dateFrom")LocalDateTime dateFrom);
}
