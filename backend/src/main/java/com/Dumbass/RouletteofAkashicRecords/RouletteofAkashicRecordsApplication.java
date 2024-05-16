package com.Dumbass.RouletteofAkashicRecords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RouletteofAkashicRecordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RouletteofAkashicRecordsApplication.class, args);
	}

}
