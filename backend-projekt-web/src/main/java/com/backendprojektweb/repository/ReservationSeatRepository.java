package com.backendprojektweb.repository;

import com.backendprojektweb.model.ReservationSeat;
import com.backendprojektweb.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationSeatRepository extends JpaRepository<ReservationSeat, Long> {
    @Query(value = "SELECT rs " +
            "FROM #{#entityName} rs " +
            "JOIN rs.reservation r " +
            "JOIN r.screening sc " +
            "WHERE sc.id = :screeningId")
    List<ReservationSeat> unavailableReservationSeatsDuringScreening(@Param("screeningId") Long screeningId);
    @Query(value = "SELECT st " +
            "FROM #{#entityName} rs " +
            "JOIN rs.reservation r " +
            "JOIN r.screening sc " +
            "JOIN rs.seat st " +
            "WHERE sc.id = :screeningId")
    List<Seat> unavailableSeatsDuringScreening(@Param("screeningId") Long screeningId);
}
