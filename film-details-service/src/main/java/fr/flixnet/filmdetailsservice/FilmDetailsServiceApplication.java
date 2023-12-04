package fr.flixnet.filmdetailsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class FilmDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmDetailsServiceApplication.class, args);
	}

}
