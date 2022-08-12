package com.project.springboot.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="trades")
public class Trade implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "ticker")private String ticker;
    @Column(name = "currency")private String currency;
    @Column(name = "price")private Double price;
    @Column(name = "shares")private Integer shares;
    @Column(name = "date")private Date date;

    public Trade(){

    }

    public Trade(int id, String ticker, String currency, Double price, Integer shares, Date date) {

        this.id = id;
        this.ticker = ticker;
        this.currency = currency;
        this.price = price;
        this.shares = shares;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
