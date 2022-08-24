package com.project.springboot.service;


import com.project.springboot.entities.Trade;
import com.project.springboot.repo.TradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@Service
public class TradeService  implements TradeServiceInterface {
    @Autowired
    private TradeRepo dao;

    @Override
    public Collection<Trade> getAllTrades() {
        return dao.findAll();
    }

    @Override
    public List<Trade> getTradeByTicker(String ticker) {
        return dao.findByTicker(ticker);
    }

    @Override
    public Trade addNewTrade(Trade trade) {
        return dao.save(trade);
    }

    @Override
    public String getApiData(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    @Override
    public int getCurrentAmountShares(String ticker) {
        return dao.getCurrentAmountShares(ticker);

    }

    @Override
    public List<String> getAllTickers() {
        return dao.getAllTickers();
    }

    @Override
    public float getStockValue(String ticker) { return dao.getStockValue(ticker); }


}
