package com.nasir.premiummembergateway.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfiguration {

	@Value("${spring.database.url}")
	private String url;
	
	@Value("${spring.database.user}")
	private String usename;
	
	@Value("${spring.database.pass}")
	private String password;
	
	@SuppressWarnings("rawtypes")
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url(url);
        dataSourceBuilder.username(usename);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
	}
	
	@Bean(name = "postgreJdbcTemplate")
	public JdbcTemplate postgreJdbcTemplate(
			@Qualifier("dataSource") DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}
}
