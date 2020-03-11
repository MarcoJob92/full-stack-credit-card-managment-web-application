package com.fullstackwebbapp.maven.backend_credit_card_system_marco_furone_publicis_sapient;

public class DbConstants {
	
	public static final String JDBC_DRIVER = "org.h2.Driver";   
	public static final String DB_URL = "jdbc:h2:~/test";
	public static final String USER = "sa"; 
	public static final String PASS = "";
	
	public static final String GET_ALL_QUERY = "SELECT * FROM CREDIT_CARD";
	public static final String INSERT_QUERY = "INSERT INTO CREDIT_CARD (name, number, card_limit, balance) VALUES (?, ?, ?, ?)";
	public static final String CREATE_TABLE_QUERY = "DROP TABLE IF EXISTS CREDIT_CARD; " +
													"CREATE TABLE CREDIT_CARD" + 
												    " (name VARCHAR(255), " +
												    " number VARCHAR(20) PRIMARY KEY, " +
												    " card_limit INTEGER, " +  
												    " balance INTEGER)";
	
}
