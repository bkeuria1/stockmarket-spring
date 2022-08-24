package com.project.springboot.service;

import com.project.springboot.entities.Trade;

import java.util.Collection;
import java.util.List;

public interface TradeServiceInterface {
     Collection<Trade>getAllTrades();
    List<Trade> getTradeByTicker(String ticker);
    Trade addNewTrade(Trade trade);
    String getApiData(String url);
    int getCurrentAmountShares(String ticker);
    List<String>getAllTickers();
    float getStockValue(String ticker);
}
