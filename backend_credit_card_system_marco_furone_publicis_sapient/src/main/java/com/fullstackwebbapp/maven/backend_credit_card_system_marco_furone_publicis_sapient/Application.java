package com.fullstackwebbapp.maven.backend_credit_card_system_marco_furone_publicis_sapient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		CreditCardService.init();
	}
}