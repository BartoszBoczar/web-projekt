package com.backendprojektweb;

import com.backendprojektweb.model.Movie;
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
    int serverPort;

    String body = "{\n" +
            "\t\"title\": \"This_is_a_test\",\n" +
            "\t\"description\": \"test\",\n" +
            "\t\"duration\": 111,\n" +
            "\t\"image\": \"\"\n" +
            "}";

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
    void testPostRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(body, headers);
        ResponseEntity<Movie> responseEntity = testRestTemplate.exchange("http://localhost:" + serverPort + "/movies",
                HttpMethod.POST, entity, Movie.class);
        Movie movie = (Movie) responseEntity.getBody();
        assert movie != null;
        assertEquals("This_is_a_test", movie.getTitle());
    }
}
