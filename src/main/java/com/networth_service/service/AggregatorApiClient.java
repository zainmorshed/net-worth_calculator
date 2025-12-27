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
            return response.getBody();
        } catch (Exception e) {
            System.err.println("Failed to fetch investment data: " + e.getMessage());
            // Return default data if API fails
            return new InvestmentData();
        }
    }
}