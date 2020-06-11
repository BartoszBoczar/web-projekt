package com.backendprojektweb;

import com.backendprojektweb.model.ReservationSeat;
import com.backendprojektweb.model.Seat;
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
class SeatControllerTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int serverPort;

    @Test
    void testGetAllRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(headers);
        ResponseEntity responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/seats",
                HttpMethod.GET, entity, List.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testGetIdRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(headers);
        ResponseEntity<Seat> responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/seats/1",
                HttpMethod.GET, entity, Seat.class);
        Seat seat = (Seat) responseEntity.getBody();
        assert seat != null;
        assertEquals(1, seat.getId());
    }

    @Test
    void testPutRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body =  "{\n" +
                "    \"seat\": {\n" +
                "        \"row\": 1,\n" +
                "        \"column\": 1\n" +
                "    },\n" +
                "    \"hallId\": 1\n" +
                "}";
        HttpEntity<String>entity = new HttpEntity<>(body, headers);
        ResponseEntity<Seat> responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/seats",
                HttpMethod.PUT, entity, Seat.class);
        Seat seat = (Seat) responseEntity.getBody();
        assert seat != null;
        assert seat.getHall().getId() == 1;
        assert seat.getRow() == 1;
        assert seat.getColumn() == 1;
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
