package com.backendprojektweb.repository;

import com.backendprojektweb.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Query(value = "SELECT st " +
            "FROM #{#entityName} st " +
            "JOIN st.hall h " +
            "WHERE h.id = :hallId")
    List<Seat> seatsInHall(@Param("hallId") Long hallId);
}
