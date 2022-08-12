package com.project.springboot.rest;

import com.project.springboot.entities.Trade;
import com.project.springboot.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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
        return service.getTradeByTicker(ticker);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addTrade(@RequestBody Trade trade){
        service.addNewTrade(trade);
    }


}
