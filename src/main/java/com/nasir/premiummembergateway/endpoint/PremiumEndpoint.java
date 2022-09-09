package com.nasir.premiummembergateway.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.nasir.premiummember.GetPremiumMemberRequest;
import com.nasir.premiummember.GetPremiumMemberResponse;
import com.nasir.premiummember.PremiumDetails;
import com.nasir.premiummembergateway.clientexception.CustomException;
import com.nasir.premiummembergateway.repository.PremiumDbRepository;

@Endpoint
public class PremiumEndpoint {
	
	  private static final String NAMESPACE_URI = "http://nasir.com/premiummember";
	  
	  @Autowired
	  private PremiumDbRepository premiumDbRepository;
	  
	  @ResponsePayload
	  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPremiumMemberRequest") 
	  public GetPremiumMemberResponse getPcdDetails(@RequestPayload GetPremiumMemberRequest request) {
		  GetPremiumMemberResponse response = new GetPremiumMemberResponse();
		  List<PremiumDetails> pd1 = premiumDbRepository.details(request.getName());
		  if(!pd1.isEmpty()) {
			  if(pd1.get(0).getFfpClass().equals("S")) {
				  pd1.get(0).setFfpClass("Silver");
			  }else {
				  pd1.get(0).setFfpClass("Gold");
			  }
			  response.setPremiumDetails(pd1.get(0));
		  }else {
			  throw new CustomException("Member Not Found " + request.getName());
		  }
		  return response; 
	  }
	  
	  
}
