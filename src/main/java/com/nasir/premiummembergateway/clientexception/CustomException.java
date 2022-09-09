package com.nasir.premiummembergateway.clientexception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT) //customFaultCode = "{http://nasir.com/premiummember}404-MemberNotFound")
public class CustomException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CustomException(String Msg) {
		super(Msg);
	}
	
}
