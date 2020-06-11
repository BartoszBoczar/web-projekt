package com.backendprojektweb;

import com.backendprojektweb.model.Screening;
import com.backendprojektweb.model.Seat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ScreeningControllerTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int serverPort;

    @Test
    void testGetAllRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(headers);
        ResponseEntity responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/screenings",
                HttpMethod.GET, entity, List.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testGetIdRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(headers);
        ResponseEntity<Screening> responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/screenings/1",
                HttpMethod.GET, entity, Screening.class);
        Screening screening = (Screening) responseEntity.getBody();
        assert screening != null;
        assertEquals(60.50, screening.getPrice());
    }

    @Test
    void testGetScreeningsOfMovieRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(headers);
        ParameterizedTypeReference<List<Screening>> typeReference = new ParameterizedTypeReference<List<Screening>>() {
        };
        ResponseEntity<List<Screening>> responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/screenings/movie/1",
                HttpMethod.GET, entity, typeReference);
        List<Screening> screenings = responseEntity.getBody();
        assert screenings != null;
        for(Screening screening: screenings) {
            assert screening != null;
            assertEquals(1, screening.getMovie().getId());
        }
    }

    @Test
    void testGetScreeningsOfMovieFromNowRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(headers);
        ParameterizedTypeReference<List<Screening>> typeReference = new ParameterizedTypeReference<List<Screening>>() {
        };
        ResponseEntity<List<Screening>> responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/screenings/movieFromNow/1",
                HttpMethod.GET, entity, typeReference);
        List<Screening> screenings = responseEntity.getBody();
        assert screenings != null;
        for(Screening screening: screenings) {
            assert screening != null;
            assertEquals(1, screening.getMovie().getId());
            assert LocalDateTime.now().isBefore(screening.getTime());
        }
    }

    @Test
    void testPutRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body =  "{\n" +
                "    \"screening\": {\n" +
                "        \"time\": \"2020-12-12T00:00:01\",\n" +
                "        \"price\": 12.0\n" +
                "    },\n" +
                "    \"movieId\": 1,\n" +
                "    \"hallId\": 1\n" +
                "}";
        HttpEntity<String>entity = new HttpEntity<>(body, headers);
        ResponseEntity<Screening> responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/screenings",
                HttpMethod.PUT, entity, Screening.class);
        Screening screening = (Screening) responseEntity.getBody();
        assert screening != null;
        assert screening.getPrice() == 12.0;
        assert screening.getHall().getId() == 1;
        assert screening.getMovie().getId() == 1;
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
