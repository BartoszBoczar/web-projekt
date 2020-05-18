package com.backendprojektweb;

import com.backendprojektweb.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class MovieControllerTests {

    String body = "{\n" +
            "\t\"title\": \"This_is_a_test\",\n" +
            "\t\"description\": \"test\",\n" +
            "\t\"duration\": 111,\n" +
            "\t\"image\": \"\"\n" +
            "}";

    @Test
    void testGetAllRequest() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(headers);
        ResponseEntity responseEntity = testRestTemplate.exchange("http://localhost:8080/movies",
                HttpMethod.GET, entity, List.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testGetIdRequest() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(headers);
        ResponseEntity responseEntity = testRestTemplate.exchange("http://localhost:8080/movies/1",
                HttpMethod.GET, entity, Movie.class);
        Movie movie = (Movie) responseEntity.getBody();
        assertEquals("Shrek", movie.getTitle());
    }

    @Test
    void testPostRequest() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<>(body, headers);
        ResponseEntity responseEntity = testRestTemplate.exchange("http://localhost:8080/movies",
                HttpMethod.POST, entity, Movie.class);
        Movie movie = (Movie) responseEntity.getBody();
        assertEquals("This_is_a_test", movie.getTitle());
    }
}
