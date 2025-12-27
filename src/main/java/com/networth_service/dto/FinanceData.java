package com.networth_service.dto;

public class FinanceData {

    private double checkingBalance;
    private double savingsBalance;

    public FinanceData() {}

    public double getCheckingBalance() { 
        return checkingBalance; 
    }
    
    public void setCheckingBalance(double checkingBalance) { 
        this.checkingBalance = checkingBalance; 
    }
    
    public double getSavingsBalance() { 
        return savingsBalance; 
    }
    
    public void setSavingsBalance(double savingsBalance) { 
        this.savingsBalance = savingsBalance; 
    }
    
    public double getTotalBalance() {
        return checkingBalance + savingsBalance;
    }
}