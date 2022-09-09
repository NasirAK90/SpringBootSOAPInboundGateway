package com.nasir.premiummembergateway.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nasir.premiummember.PremiumDetails;

@Repository
public class PremiumDbRepository {

	@Autowired
	@Qualifier("postgreJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings({ "unchecked"})
	public List<PremiumDetails> details(String name){ 
		
		return  jdbcTemplate.query("select ffpid,ffpname,ffpclass from premiummember where ffpname = ?", 
				new Object[]{name}, new PremiumRowMapper());
		
	}
}
