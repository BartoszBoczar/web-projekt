package com.backendprojektweb.repository;

import com.backendprojektweb.model.ReservationSeat;
import com.backendprojektweb.model.Screening;
import com.backendprojektweb.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationSeatRepository extends JpaRepository<ReservationSeat, Long> {
//    @Query(value = "SELECT rs " +
//            "FROM reservations_seats rs " +
//            "JOIN seats st ON rs.reservation = st.id " +
//            "JOIN halls h ON st.hall = h.id " +
//            "JOIN screenings sc ON sc.hall = h.id " +
//            "WHERE sc.id = :screeningId")

//    @Query(value = "SELECT rs " +
//            "FROM #{#entityName} rs " +
//            "JOIN rs.seat st " +
//            "JOIN st.hall h " +
//            "JOIN h.screeningList sc " +
//            "WHERE sc.id = :screeningId")
    @Query(value = "SELECT rs " +
            "FROM #{#entityName} rs " +
            "JOIN rs.reservation r " +
            "JOIN r.screening sc " +
            "WHERE sc.id = :screeningId")
    public List<ReservationSeat> unavailableReservationSeatsDuringScreening(@Param("screeningId") Long screeningId);
    @Query(value = "SELECT st " +
            "FROM #{#entityName} rs " +
            "JOIN rs.reservation r " +
            "JOIN r.screening sc " +
            "JOIN rs.seat st " +
            "WHERE sc.id = :screeningId")
    public List<Seat> unavailableSeatsDuringScreening(@Param("screeningId") Long screeningId);
}
