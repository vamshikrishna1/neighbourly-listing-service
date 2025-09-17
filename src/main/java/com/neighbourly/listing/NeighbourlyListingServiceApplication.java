package com.neighbourly.listing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NeighbourlyListingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeighbourlyListingServiceApplication.class, args);
	}

}
