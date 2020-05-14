package com.backendprojektweb;

import com.backendprojektweb.api.RestGetController;
import com.backendprojektweb.api.RestPostController;
import com.backendprojektweb.api.RestPutController;
import com.backendprojektweb.model.Movie;
import com.backendprojektweb.repository.MovieRepository;
import com.backendprojektweb.service.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {RestGetController.class, RestPostController.class, RestPutController.class, MovieService.class})
public class BackendProjektWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendProjektWebApplication.class, args);
	}

}
