package com.networth_service.service;

import com.networth_service.dto.InvestmentData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AggregatorApiClient {
    
    private final RestTemplate restTemplate;
    
    @Value("${api.aggregator.url}")
    private String aggregatorApiUrl;
    
    public AggregatorApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public InvestmentData getInvestmentData(String username, String bearerToken) {
        String url = aggregatorApiUrl + "/summary?user=" + username;
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + bearerToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        try {
            ResponseEntity<InvestmentData> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                InvestmentData.class
            );
            System.out.println("Response from Aggregator API: " + response.getBody()); // ADD THIS
            System.out.println("Response status: " + response.getStatusCode()); // ADD THIS TOO
            return response.getBody();
        } catch (Exception e) {
            System.err.println("Failed to fetch investment data: " + e.getMessage());
            e.printStackTrace(); // ADD THIS
            return new InvestmentData();
        }
    }
}