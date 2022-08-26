package com.project.springboot.rest;

import com.project.springboot.entities.ApiResponse;
import com.project.springboot.entities.TickerSummary;
import com.project.springboot.entities.Trade;
import com.project.springboot.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/trades")
@CrossOrigin // allows requests from all domains
public class TradeController {
    @Autowired
    private TradeService service;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Trade> getAllTrades(){
        return service.getAllTrades();
    }

    @RequestMapping(method = RequestMethod.GET, value="/{ticker}")
    public Collection<Trade> findByTicker(@PathVariable("ticker") String ticker){
        return service.getTradeByTicker(ticker.toUpperCase());
    }



    @RequestMapping(method = RequestMethod.GET, value = "/currentPrice")
    public float getPrice(@RequestParam String ticker){
        String url =  "https://3p7zu95yg3.execute-api.us-east-1.amazonaws.com/default/priceFeed2?ticker="+ticker+"&num_days=1";
        ApiResponse response = service.getApiData(url);
        float currentPrice = response.getPriceData().get(0).getValue();
        return currentPrice;

    }
    @RequestMapping(method = RequestMethod.GET, value = "/total")
    public int getTotalShares(@RequestParam String ticker){
        return service.getCurrentAmountShares(ticker);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/stockValue")
    public float getStockValue(@RequestParam String ticker){
        return service.getStockValue(ticker);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tickerSummary")
    public TickerSummary getTickerSummary(@RequestParam String ticker) throws JSONException {
        String url = "https://3p7zu95yg3.execute-api.us-east-1.amazonaws.com/default/priceFeed2?ticker="+ticker+"&num_days=1";
        ApiResponse apiResponse = service.getApiData(url);
        float position = service.getStockValue(ticker);
        float currentPrice = apiResponse.getPriceData().get(0).getValue();
        int shares = service.getCurrentAmountShares(ticker);
        float profit = shares*currentPrice - position;
        return new TickerSummary(ticker, position, shares, profit, currentPrice);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/post")
    public void addTrade(@RequestBody Trade trade){
        service.addNewTrade(trade);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tickers")
    public List<String> getAllTickers(){
        return service.getAllTickers();
    }

}
