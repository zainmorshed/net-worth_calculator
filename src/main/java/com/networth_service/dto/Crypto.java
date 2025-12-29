package com.networth_service.dto;

public class Crypto {
    private String symbol;
    private String name;
    private double price;
    private double quantity;
    
    public Crypto() {}
    
    public String getSymbol() { 
        return symbol; 
    }
    
    public void setSymbol(String symbol) { 
        this.symbol = symbol; 
    }
    
    public String getName() { 
        return name; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }
    
    public double getPrice() { 
        return price; 
    }
    
    public void setPrice(double price) { 
        this.price = price; 
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}