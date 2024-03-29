package com.backendprojektweb;

import com.backendprojektweb.model.Movie;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieControllerTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int serverPort;

    @Test
    void testGetAllRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(headers);
        ResponseEntity responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/movies",
                HttpMethod.GET, entity, List.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testGetIdRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(headers);
        ResponseEntity<Movie> responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/movies/1",
                HttpMethod.GET, entity, Movie.class);
        Movie movie = (Movie) responseEntity.getBody();
        assert movie != null;
        assertEquals("Shrek", movie.getTitle());
    }

    @Test
    void testPutRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = "{\n" +
                "\t\"title\": \"Test\",\n" +
                "\t\"description\": \"Test\",\n" +
                "\t\"duration\": 111,\n" +
                "\t\"image\": \"\"\n" +
                "}";
        HttpEntity<String>entity = new HttpEntity<>(body, headers);
        ResponseEntity<Movie> responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/movies",
                HttpMethod.PUT, entity, Movie.class);
        Movie movie = (Movie) responseEntity.getBody();
        assert movie != null;
        assert movie.getTitle().equals("Test");
        assert movie.getDescription().equals("Test");
        assert movie.getDuration() == 111;
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
