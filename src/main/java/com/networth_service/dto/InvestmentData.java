package com.networth_service.dto;

import java.util.List;

public class InvestmentData {
    

    private String username;
    private List<Stock> stocks;
    private List<Crypto> cryptos;

    public InvestmentData(){}

    

    public InvestmentData(String username, List<Stock> stocks, List<Crypto> cryptos) {
        this.username = username;
        this.stocks = stocks;
        this.cryptos = cryptos;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public List<Crypto> getCryptos() {
        return cryptos;
    }

    public void setCryptos(List<Crypto> cryptos) {
        this.cryptos = cryptos;
    }


    public double getTotalValue() {
        double stockValue = stocks != null ? 
            stocks.stream().mapToDouble(Stock::getPrice).sum() : 0.0;
        double cryptoValue = cryptos != null ? 
            cryptos.stream().mapToDouble(Crypto::getPrice).sum() : 0.0;
        return stockValue + cryptoValue;
    }


}
