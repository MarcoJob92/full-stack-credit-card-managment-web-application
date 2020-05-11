package com.fullstackwebbapp.maven.backend_credit_card_system_marco_furone_publicis_sapient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullstackwebbapp.maven.backend_credit_card_system.entities.CreditCard;
import com.fullstackwebbapp.maven.backend_credit_card_system_marco_furone_publicis_sapient.controllers.CreditCardController;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.assertj.core.util.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})

public class CreditCardServiceIntegrationTests {
	
	@Autowired
	CreditCardController controller;

    MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = standaloneSetup(controller).build();
    }
    
    
    @Test
    public void testGetAllCreditCardsIsEmpty_testPostServiceToAddCreditCardObjects_testGetAllCreditCardsIsCorrectlyPopulated() throws Exception {
        mockMvc.perform(
            MockMvcRequestBuilders.get("/creditCards/getAll"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());
        
        mockMvc.perform( MockMvcRequestBuilders
            	.post("/creditCards/add")
                .content(new ObjectMapper().writeValueAsString(new CreditCard("Marco", "1111222233334444", 20, 0)))
                .contentType(MediaType.APPLICATION_JSON)
    		    .accept(MediaType.APPLICATION_JSON))
    		    .andExpect(status().isOk());
        
        mockMvc.perform(
                MockMvcRequestBuilders.get("/creditCards/getAll"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(MockMvcResultMatchers.jsonPath("$[*].number").value(Lists.newArrayList("1111222233334444")));
    }
	
}
