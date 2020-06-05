package com.backendprojektweb.repository;

import com.backendprojektweb.model.ReservationSeat;
import com.backendprojektweb.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationSeatRepository extends JpaRepository<ReservationSeat, Long> {
//    @Query(value = "SELECT rs " +
//            "FROM #{#entityName} rs " +
//            "JOIN seats st ON rs.reservation_id = st.id " +
//            "JOIN halls h ON st.hall_id = h.id " +
//            "JOIN screenings sc ON sc.hallId = h.id " +
//            "WHERE sc.id = :screeningId")
    @Query(value = "SELECT rs " +
            "FROM #{#entityName} rs " +
            "JOIN rs.seatId st " +
            "JOIN st.hallId h " +
            "JOIN h.screeningList sc " +
            "WHERE sc.id = :screeningId")
    public List<ReservationSeat> unavailableSeatsDuringScreening(@Param("screeningId") Long screeningId);
}
