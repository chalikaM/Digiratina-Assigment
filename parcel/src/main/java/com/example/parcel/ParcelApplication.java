package com.example.parcel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ParcelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParcelApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		// Return a RestTemplat instance which will be used to call other external
		// microservices
		return new RestTemplate();
	}

}
