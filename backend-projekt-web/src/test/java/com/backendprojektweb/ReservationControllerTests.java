package com.backendprojektweb;

import com.backendprojektweb.model.Movie;
import com.backendprojektweb.model.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReservationControllerTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int serverPort;

    @Test
    void testGetAllRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(headers);
        ResponseEntity responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/reservations",
                HttpMethod.GET, entity, List.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testGetIdRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(headers);
        ResponseEntity<Reservation> responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/reservations/1",
                HttpMethod.GET, entity, Reservation.class);
        Reservation reservation = (Reservation) responseEntity.getBody();
        assert reservation != null;
        assertEquals("Nehru", reservation.getName());
    }

    @Test
    void testPutRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body =  "{\n" +
                "    \"reservation\": {\n" +
                "        \"name\": \"Name\",\n" +
                "        \"surname\": \"Surname\",\n" +
                "        \"email\": \"Email\"\n" +
                "    },\n" +
                "    \"seatDTOList\": [\n" +
                "        {\n" +
                "            \"seat\": {\n" +
                "                \"row\": 3,\n" +
                "                \"column\":2\n" +
                "            },\n" +
                "            \"hallId\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"seat\": {\n" +
                "                \"row\": 3,\n" +
                "                \"column\": 3\n" +
                "            },\n" +
                "            \"hallId\": 1\n" +
                "        }\n" +
                "    ],\n" +
                "    \"screeningId\": 1\n" +
                "}";
        HttpEntity<String>entity = new HttpEntity<>(body, headers);
        ResponseEntity<Reservation> responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/reservations",
                HttpMethod.PUT, entity, Reservation.class);
        Reservation reservation = (Reservation) responseEntity.getBody();
        assert reservation != null;
        assert reservation.getName().equals("Name");
        assert reservation.getSurname().equals("Surname");
        assert reservation.getEmail().equals("Email");
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
