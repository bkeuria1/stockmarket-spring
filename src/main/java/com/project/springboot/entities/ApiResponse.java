package com.project.springboot.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class ApiResponse implements Serializable {

    String ticker;
    @JsonProperty("price_data")
    ArrayList<PriceData> priceData;

    public ApiResponse() {}

    public ApiResponse(String ticker, ArrayList<PriceData> priceData) {
        this.ticker = ticker;
        this.priceData = priceData;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public ArrayList<PriceData> getPriceData() {
        return priceData;
    }

    public void setPriceData(ArrayList<PriceData> priceData) {
        this.priceData = priceData;
    }
}
