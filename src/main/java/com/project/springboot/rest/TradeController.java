package com.project.springboot.rest;

import com.project.springboot.entities.Trade;
import com.project.springboot.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/api/trades")
@CrossOrigin // allows requests from all domains
public class TradeController {
    @Autowired
    private TradeService service;

    private RestTemplate restTemplate = new RestTemplate();


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Trade> getAllTrades(){
        return service.getAllTrades();
    }

    @RequestMapping(method = RequestMethod.GET, value="/{ticker}")
    public Collection<Trade> findByTicker(@PathVariable("ticker") String ticker){
        return service.getTradeByTicker(ticker);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/currentPrices/{ticker}")
    public String  getCurrentPrice(@PathVariable("ticker")String ticker){
        String url = "https://c4rm9elh30.execute-api.us-east-1.amazonaws.com/default/cachedPriceData?ticker=" + ticker;
        String  result = restTemplate.getForObject(url,String.class);
        return result;

    }

    @RequestMapping(method = RequestMethod.GET, value = "/history")
    public String getPrice(@RequestParam String ticker, @RequestParam String days){
        String url =  "https://3p7zu95yg3.execute-api.us-east-1.amazonaws.com/default/priceFeed2?ticker="+ticker+"&num_days="+days;
        String  result = restTemplate.getForObject(url,String.class);
        return result;

    }

    /*

     */
//    @RequestMapping(method = RequestMethod.GET, value = "/find")
//    public String getPrice(@RequestParam String ticker){
//        String url =  "https://3p7zu95yg3.execute-api.us-east-1.amazonaws.com/default/priceFeed2?ticker="+ticker+"&num_days="+days;
//        String  result = restTemplate.getForObject(url,String.class);
//        return result;
//
//    }

    @RequestMapping(method = RequestMethod.POST)
    public void addTrade(@RequestBody Trade trade){
        service.addNewTrade(trade);
    }



}
