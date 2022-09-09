# SpringBoot SOAP API 
Spring Boot :-> Receive Soap Request & Then Respond  
     
This is a spring boot application which will receive a soap request 
and respond based on the name parameter of request.

Request

      <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
          xmlns:us="http://nasir.com/premiummember">
          <soapenv:Header/>
          <soapenv:Body>
              <us:getPremiumMemberRequest>
                  <us:name>Nasir</us:name>
              </us:getPremiumMemberRequest>
          </soapenv:Body>
      </soapenv:Envelope>

Database used in this application is postgres. Table structure is described below

CREATE TABLE IF NOT EXISTS premiummember
(
    ffpid integer NOT NULL,
    ffpname  character(20)  NOT NULL,
    ffpclass character(1)  NOT NULL
)

we can generate the WSDL after running the spring boot application
      http://localhost:9090/premiumservice/premium.wsdl
      
    
