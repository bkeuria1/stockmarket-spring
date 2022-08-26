import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { PriceService } from '../price.service';
import { Trade } from '../trade';
import { TradeServiceService } from '../trade-service.service';

@Component({
  selector: 'app-buy-and-sell',
  templateUrl: './buy-and-sell.component.html',
  styleUrls: ['./buy-and-sell.component.css']
})
export class BuyAndSellComponent implements OnInit {
  ticker!:string
  finalTicker!:string
  shares!:number
  currentPrice!:number
  isBuying! : boolean
  tradeType!:string
  constructor(private priceService: PriceService, private tradeService :TradeServiceService) { }

  ngOnInit(): void {
  }
  searchStock(form:NgForm){
    this.finalTicker =this.ticker
    let currentPriceApiCall = this.priceService.getCurrentPrice(this.ticker)
    currentPriceApiCall.subscribe(result=>{
      this.currentPrice = result
    })
    }
  
  tradeStock(form:NgForm){
    console.log(this.tradeType)
    if(this.tradeType === "Buy"){
      this.isBuying = true
    }else{
      this.isBuying = false
    }
    let trade:Trade = new Trade(this.finalTicker,"USD",this.shares,this.currentPrice,new Date(Date.now()),this.isBuying)
    console.log(trade)
    this.tradeService.addTrade(trade)
  }

}
