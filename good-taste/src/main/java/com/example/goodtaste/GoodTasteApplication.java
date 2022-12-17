package com.example.goodtaste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GoodTasteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodTasteApplication.class, args);
	}

}
