package com.nasir.premiummembergateway.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nasir.premiummember.PremiumDetails;

@SuppressWarnings("rawtypes")
public class PremiumRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		PremiumDetails pd = new PremiumDetails();
		pd.setFfpNumber(rs.getInt(1));
		pd.setName(rs.getString(2));
		pd.setFfpClass(rs.getString(3));
		return pd;
		
	}

}
