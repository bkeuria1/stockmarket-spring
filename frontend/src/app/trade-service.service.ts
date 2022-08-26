import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Trade } from './trade';

@Injectable({
  providedIn: 'root'
})
export class TradeServiceService {

  url:string = "http://localhost:8080/api/trades";
  constructor(private http:HttpClient) {}

  getTrades() {
    return this.http.get(this.url) as Observable<Array<Trade>>
  }
  addTrade(trade:Trade){
    return this.http.post(this.url+"/post", trade) as Observable<Trade>

  }

}
/*
for every ticker, generate a summaryObject
store each object in array (tickerSummary)
*/

