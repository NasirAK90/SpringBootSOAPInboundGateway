package com.nasir.premiummembergateway.repository;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.nasir.premiummember.PremiumDetails;

@Service
public class PremiumRepository {

	    private static final Map<String, PremiumDetails> primiumCustomerDetails = new HashMap<>();
	
	    @PostConstruct
		public void initData() {
				  
	      PremiumDetails pcdSajal = new PremiumDetails(); 
    	  pcdSajal.setName("Sajal");
    	  pcdSajal.setFfpNumber(100); 
    	  pcdSajal.setFfpClass("Gold");
    	  
    	  PremiumDetails pcdNasir = new PremiumDetails(); 
    	  pcdNasir.setName("Nasir");
    	  pcdNasir.setFfpNumber(101); 
    	  pcdNasir.setFfpClass("Gold");
    	  
    	  PremiumDetails pcdGopal = new PremiumDetails(); 
    	  pcdGopal.setName("Gopal");
    	  pcdGopal.setFfpNumber(102); 
    	  pcdGopal.setFfpClass("Silver");
    	  
    	  primiumCustomerDetails.put(pcdNasir.getName(), pcdNasir);
    	  primiumCustomerDetails.put(pcdGopal.getName(), pcdGopal);
    	  primiumCustomerDetails.put(pcdSajal.getName(), pcdSajal);
		   
		 }
	  
		public PremiumDetails findPremiumDetails(String name) { 
		  Assert.notNull(name,"The Premium Customer name must not be null"); 
		  return primiumCustomerDetails.get(name); 
		}
		 
}
