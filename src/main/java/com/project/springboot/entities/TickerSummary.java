package com.project.springboot.entities;

public class TickerSummary {
    String ticker;
    int shares;
    float position;
    float profit;
    float currentPrice;

    public TickerSummary(String ticker, float position, int shares, float profit, float currentPrice) {
        this.ticker = ticker;
        this.shares = shares;
        this.position = position;
        this.profit = profit;
        this.currentPrice = currentPrice;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public float getPosition() {
        return position;
    }

    public void setPosition(float position) {
        this.position = position;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }
}
