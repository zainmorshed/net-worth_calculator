package com.networth_service.service;

import com.networth_service.service.AggregatorApiClient;
import com.networth_service.service.FinanceApiClient;
import com.networth_service.dto.FinanceData;
import com.networth_service.dto.InvestmentData;
import com.networth_service.dto.NetWorthResponse;
import org.springframework.stereotype.Service;
import java.time.Instant;



@Service
public class NetWorthService {
    
    private final FinanceApiClient financeClient;
    private final AggregatorApiClient aggregatorClient;
    
    public NetWorthService(FinanceApiClient financeClient, 
                          AggregatorApiClient aggregatorClient) {
        this.financeClient = financeClient;
        this.aggregatorClient = aggregatorClient;
    }
    
    public NetWorthResponse calculateNetWorth(String username, String bearerToken) {
        // Call Finance API
        FinanceData financeData = financeClient.getFinanceData(username, bearerToken);
        double bankBalance = financeData.getTotalBalance();
        
        // Call Aggregator API
        InvestmentData investmentData = aggregatorClient.getInvestmentData(username, bearerToken);
        double investmentValue = investmentData.getTotalValue();
        
        // Calculate total net worth
        double totalNetWorth = bankBalance + investmentValue;
        
        return new NetWorthResponse(
            username,
            totalNetWorth,
            bankBalance,
            investmentValue,
            Instant.now().toString()
        );
    }
}