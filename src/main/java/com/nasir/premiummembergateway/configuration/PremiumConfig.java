package com.nasir.premiummembergateway.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


@EnableWs
@Configuration
public class PremiumConfig extends WsConfigurerAdapter {
	 
	  @Bean 
	  public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		  MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		  servlet.setApplicationContext(applicationContext);
		  servlet.setTransformWsdlLocations(true); 
		  return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/premiumservice/*"); 
	  }
	  
	  @Bean 
	  public XsdSchema pcdDetailsSchema() { 
		  return new SimpleXsdSchema(new ClassPathResource("premium.xsd")); 
	  }
	  
	  @Bean(name = "premium")
	  public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema pcdDetailsSchema) { 
		  
		  DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		  wsdl11Definition.setPortTypeName("PremiumServicePort");
		  wsdl11Definition.setLocationUri("/premiumservice");
		  wsdl11Definition.setTargetNamespace("http://nasir.com/premiummember");
		  wsdl11Definition.setSchema(pcdDetailsSchema); 
		  return wsdl11Definition; 
	  }
	  
}	  
