package com.project.springboot.service;

import com.project.springboot.entities.ApiResponse;
import com.project.springboot.entities.Trade;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.Collection;
import java.util.List;

public interface TradeServiceInterface {
     Collection<Trade>getAllTrades();
    List<Trade> getTradeByTicker(String ticker);
    Trade addNewTrade(Trade trade);
    ApiResponse getApiData(String url);
    int getCurrentAmountShares(String ticker);
    List<String>getAllTickers();
    float getStockValue(String ticker);
}
