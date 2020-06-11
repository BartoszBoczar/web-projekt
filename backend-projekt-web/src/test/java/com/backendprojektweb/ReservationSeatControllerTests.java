package com.backendprojektweb;

import com.backendprojektweb.model.Reservation;
import com.backendprojektweb.model.ReservationSeat;
import com.backendprojektweb.model.enumerations.Discount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReservationSeatControllerTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int serverPort;

    @Test
    void testGetAllRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(headers);
        ResponseEntity responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/reservationSeats",
                HttpMethod.GET, entity, List.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testGetIdRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(headers);
        ResponseEntity<ReservationSeat> responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/reservationSeats/1",
                HttpMethod.GET, entity, ReservationSeat.class);
        ReservationSeat reservationSeat = (ReservationSeat) responseEntity.getBody();
        assert reservationSeat != null;
        assertEquals(1, reservationSeat.getReservation().getId());
    }

    @Test
    void testPutRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body =  "{\n" +
                "    \"reservationSeat\": {\n" +
                "        \"discount\": \"NONE\"\n" +
                "    },\n" +
                "    \"reservationId\": 1,\n" +
                "    \"seatId\": 1\n" +
                "}";
        HttpEntity<String>entity = new HttpEntity<>(body, headers);
        ResponseEntity<ReservationSeat> responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/reservationSeats",
                HttpMethod.PUT, entity, ReservationSeat.class);
        ReservationSeat reservationSeat = (ReservationSeat) responseEntity.getBody();
        assert reservationSeat != null;
        assert reservationSeat.getDiscount().equals(Discount.NONE);
        assert reservationSeat.getReservation().getId() == 1;
        assert reservationSeat.getSeat().getId() == 1;
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
