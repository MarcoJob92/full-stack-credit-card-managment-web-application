package com.fullstackwebbapp.maven.backend_credit_card_system_marco_furone_publicis_sapient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {
    
    static JdbcTemplate jdbcTemplate;
    
	public List<CreditCard> findAll() {
		return jdbcTemplate.query(DbConstants.GET_ALL_QUERY, new CreditCardRowMapper());
	}
	
	public void addCreditCard (CreditCard card) {
		jdbcTemplate.update(DbConstants.INSERT_QUERY,
	    		new Object[] { card.getUserName(), card.getNumber(), card.getLimit(), 0 });
	}
	
	private class CreditCardRowMapper implements RowMapper<CreditCard> {
		public CreditCard mapRow(ResultSet rs, int rowNum) throws SQLException {
			CreditCard card= new CreditCard();
			card.setUserName(rs.getString("name"));
			card.setNumber(rs.getString("number"));
			card.setLimit(rs.getInt("card_limit"));
			card.setBalance(rs.getInt("balance"));
			return card;
		}
	}
	
	public static void init() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DbConstants.JDBC_DRIVER);
        dataSource.setUrl(DbConstants.DB_URL);
        dataSource.setUsername(DbConstants.USER);
        dataSource.setPassword(DbConstants.PASS);
        
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute(DbConstants.CREATE_TABLE_QUERY);
	}
	
}