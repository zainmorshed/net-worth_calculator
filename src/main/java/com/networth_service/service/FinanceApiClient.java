package com.networth_service.service;

import com.networth_service.dto.FinanceData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FinanceApiClient {
    
    private final RestTemplate restTemplate; //Spring's HTTP client - tool that makes HTTP requests to other APIs
    //RestTemplate = programmatic HTTP cleint (the code makes the requests)
    
    @Value("${api.finance.url}") //extract prod personalfinanceapi url stored in env variable - looks in application.yml for property: api.finance.url
    private String financeApiUrl; //store prod url for personalfinanceapi in this variable
    
    public FinanceApiClient(RestTemplate restTemplate) { 
        this.restTemplate = restTemplate;
    }
    
    public FinanceData getFinanceData(String username, String bearerToken) { 
        String url = financeApiUrl + "/finance/balance?user=" + username;
        //ex result: https://personal-finance.onrender.com/finance/balance?user=john
        
        HttpHeaders headers = new HttpHeaders(); //new headers object from HttpHeaders class - HttpHeaders = spring class for managing HTTP headers
    // .set() = method that takes 2 parameters: (headerName, headerValue) - parameter1: "Authorization" (the header name), Parameter 2: "Bearer " + bearerToken (the full header value) 
        headers.set("Authorization", "Bearer " + bearerToken);
        HttpEntity<String> entity = new HttpEntity<>(headers); 
//HttpEntity = Spring class that wraps the request (headers + optional body)
//Constructor takes: (body, headers) or just (headers) if no body - in this case just pass the headers - no body needed for GET

        //making the HTTP GET request
        try {
            ResponseEntity<FinanceData> response = restTemplate.exchange(
                url, 
                HttpMethod.GET,
                entity,
                FinanceData.class
            );
            return response.getBody();

        } catch (Exception e) {
            System.err.println("Failed to fetch finance data: " + e.getMessage());
            // Return default data if API fails
            FinanceData defaultData = new FinanceData();
            defaultData.setCheckingBalance(0.0);
            defaultData.setSavingsBalance(0.0);
            return defaultData;
        }
    }
}

//notes:
/*
spring automatically checks locations in order:
- application.yml or application.properties in src/main/resources/
- Environment variables
- command-line arguments

You could add multiple headers in the .set() method:
javaheaders.set("Authorization", "Bearer token123");
headers.set("Content-Type", "application/json");
headers.set("User-Agent", "NetWorth-Service");


ResponseEntity is a Spring class (from org.springframework.http package) that represents 
the entire HTTP response: ResponseEntity<FinanceData> response = restTemplate.exchange(...);

It contains:

Status code (200, 404, 500, etc.)
Headers (returned by the API)
Body (the actual data)

Example:
javaresponse.getStatusCode()  // 200 OK
response.getHeaders()     // Content-Type, etc.
response.getBody()        // FinanceData object

*/