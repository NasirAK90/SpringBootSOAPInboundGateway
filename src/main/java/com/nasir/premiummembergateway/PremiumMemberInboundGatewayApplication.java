package com.nasir.premiummembergateway;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {
	    DataSourceAutoConfiguration.class, 
	    DataSourceTransactionManagerAutoConfiguration.class, 
	    HibernateJpaAutoConfiguration.class
})
public class PremiumMemberInboundGatewayApplication {

	private static final Logger log = (Logger) LogManager.getLogger(PremiumMemberInboundGatewayApplication.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(PremiumMemberInboundGatewayApplication.class, args);
		log.info("*****************Application Started*************");
	}

}
