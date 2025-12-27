package com.networth_service.dto;

public class NetWorthResponse {
    private String username;
    private double totalNetWorth;
    private double bankBalance;
    private double investmentValue;
    private String timestamp;

    public NetWorthResponse() {}

    public NetWorthResponse(String username, double totalNetWorth, double bankBalance, 
                           double investmentValue, String timestamp) {
        this.username = username;
        this.totalNetWorth = totalNetWorth;
        this.bankBalance = bankBalance;
        this.investmentValue = investmentValue;
        this.timestamp = timestamp;
    }

    public String getUsername() { 
        return username; 
    }
    
    public void setUsername(String username) { 
        this.username = username; 
    }
    
    public double getTotalNetWorth() { 
        return totalNetWorth; 
    }
    
    public void setTotalNetWorth(double totalNetWorth) { 
        this.totalNetWorth = totalNetWorth; 
    }
    
    public double getBankBalance() { 
        return bankBalance; 
    }
    
    public void setBankBalance(double bankBalance) { 
        this.bankBalance = bankBalance; 
    }
    
    public double getInvestmentValue() { 
        return investmentValue; 
    }
    
    public void setInvestmentValue(double investmentValue) { 
        this.investmentValue = investmentValue; 
    }
    
    public String getTimestamp() { 
        return timestamp; 
    }
    
    public void setTimestamp(String timestamp) { 
        this.timestamp = timestamp; 
    }
}