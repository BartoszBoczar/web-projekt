package com.backendprojektweb;

import com.backendprojektweb.model.Hall;
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
class HallControllerTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int serverPort;

    @Test
    void testGetAllRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(headers);
        ResponseEntity responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/halls",
                HttpMethod.GET, entity, List.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testGetIdRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(headers);
        ResponseEntity<Hall> responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/halls/1",
                HttpMethod.GET, entity, Hall.class);
        Hall hall = (Hall) responseEntity.getBody();
        assert hall != null;
        assertEquals(1, hall.getId());
    }

    @Test
    void testPutRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body =  "{\n" +
                "\t\n" +
                "}";
        HttpEntity<String>entity = new HttpEntity<>(body, headers);
        ResponseEntity<Hall> responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/halls",
                HttpMethod.PUT, entity, Hall.class);
        Hall hall = (Hall) responseEntity.getBody();
        assert hall != null;
        assert hall.getId() == 11;
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
