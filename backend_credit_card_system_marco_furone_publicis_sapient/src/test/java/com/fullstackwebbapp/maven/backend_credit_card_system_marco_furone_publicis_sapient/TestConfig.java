package com.fullstackwebbapp.maven.backend_credit_card_system_marco_furone_publicis_sapient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fullstackwebbapp.maven.backend_credit_card_system_marco_furone_publicis_sapient.controllers.CreditCardController;
import com.fullstackwebbapp.maven.backend_credit_card_system_marco_furone_publicis_sapient.services.CreditCardService;

@Configuration
public class TestConfig {
	
    @Bean
    public CreditCardController creditCardController() {
        return new CreditCardController();
    }

	  @Bean
    public CreditCardService creditCardService() {
		CreditCardService.init();
        return new CreditCardService();
    }
	
}
