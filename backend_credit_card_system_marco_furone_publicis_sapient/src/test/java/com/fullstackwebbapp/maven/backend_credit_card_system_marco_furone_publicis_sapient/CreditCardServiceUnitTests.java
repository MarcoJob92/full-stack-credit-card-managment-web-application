package com.fullstackwebbapp.maven.backend_credit_card_system_marco_furone_publicis_sapient;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DuplicateKeyException;

import com.fullstackwebbapp.maven.backend_credit_card_system.entities.CreditCard;
import com.fullstackwebbapp.maven.backend_credit_card_system_marco_furone_publicis_sapient.services.CreditCardService;

public class CreditCardServiceUnitTests {
	
	CreditCardService creditCardManagementService;
	
	@Before
	public void init() {
		creditCardManagementService = new CreditCardService();
		CreditCardService.init();
	}


	@Test
	public void addCrediCard_retriveCard_testDupliacteKeys() {
		String cardNumber = "3333444422221111";
		CreditCard cd = new CreditCard("Marco", cardNumber, 1000, 0);
		creditCardManagementService.addCreditCard(cd);
		
		CreditCard found = creditCardManagementService.findAll()
				.stream()
				.filter(card -> card.getNumber().equals(cardNumber))
				.findFirst()
				.get();
		
		assertTrue( found.getNumber().equals(cd.getNumber()) );
		
		try {
			creditCardManagementService.addCreditCard(cd);
			fail();
		} catch (DuplicateKeyException e) {}
	}
	
	@Test
	public void testLuhn10Algorithm() {
		String cardNumber = "4716-4359-1733-0099";
		CreditCard cd = new CreditCard("Marco", cardNumber, 100, 0);
		assertTrue( cd.checkLuhn10() );
		
		String wrongCardNumber = "1111-2222-1111-2222";
		CreditCard cd2 = new CreditCard("Marco", wrongCardNumber, 100, 0);
		assertFalse( cd2.checkLuhn10() );
	}

}
