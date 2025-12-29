package com.networth_service.dto;

import java.math.BigDecimal;

public class FinanceData {
    private BigDecimal checkingBalance;
    private BigDecimal savingsBalance;
    
    public FinanceData() {}
    
    public BigDecimal getCheckingBalance() { 
        return checkingBalance != null ? checkingBalance : BigDecimal.ZERO; 
    }
    
    public void setCheckingBalance(BigDecimal checkingBalance) { 
        this.checkingBalance = checkingBalance; 
    }
    
    public BigDecimal getSavingsBalance() { 
        return savingsBalance != null ? savingsBalance : BigDecimal.ZERO; 
    }
    
    public void setSavingsBalance(BigDecimal savingsBalance) { 
        this.savingsBalance = savingsBalance; 
    }
    
    public double getTotalBalance() {
        return getCheckingBalance().add(getSavingsBalance()).doubleValue();
    }
}