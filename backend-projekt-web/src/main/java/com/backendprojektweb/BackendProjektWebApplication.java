package com.backendprojektweb;

import com.backendprojektweb.api.*;
import com.backendprojektweb.service.MovieService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackageClasses = {HallController.class, MovieController.class, ReservationController.class, ReservationSeatController.class,
		ScreeningController.class, SeatController.class, MovieService.class})
public class BackendProjektWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendProjektWebApplication.class, args);
	}

}
