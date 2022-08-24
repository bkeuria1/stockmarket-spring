package com.project.springboot.rest;

import com.project.springboot.entities.Trade;
import com.project.springboot.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(method = RequestMethod.GET, value = "/currentPrices/{ticker}")
    public String  getCurrentPrice(@PathVariable("ticker")String ticker){
        String url = "https://c4rm9elh30.execute-api.us-east-1.amazonaws.com/default/cachedPriceData?ticker=" + ticker.toUpperCase();
        return service.getApiData(url);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/history")
    public String getPrice(@RequestParam String ticker, @RequestParam String days){
        String url =  "https://3p7zu95yg3.execute-api.us-east-1.amazonaws.com/default/priceFeed2?ticker="+ticker+"&num_days="+days;
       return service.getApiData(url);

    }
    @RequestMapping(method = RequestMethod.GET, value = "/total")
    public int getTotalShares(@RequestParam String ticker){
        return service.getCurrentAmountShares(ticker);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addTrade(@RequestBody Trade trade){
        service.addNewTrade(trade);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tickers")
    public List<String> getAllTickers(){
        return service.getAllTickers();
    }
    /*create some endpoint that gets all info about a stock: ticker,#shares, $total, avg price, current price, profit
    //need seperate service functions to get these values
    //sample response
    {
        ticker:xxx,
        shares: xxx,
        total: xxx
        avg price:xxx
        current_price: xxx,
        profit: xxx
    }

     */

}
