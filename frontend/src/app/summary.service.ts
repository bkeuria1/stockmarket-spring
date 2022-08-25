import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TickerSummary } from './tickerSummary';

@Injectable({
  providedIn: 'root'
})
export class SummaryService {
  tickerUrl: string = "http://localhost:8080/api/trades/tickers"
  summaryUrl : string = "http://localhost:8080/api/trades/tickerSummary"

  constructor(private http:HttpClient) { }
  getTickers(){
    return this.http.get(this.tickerUrl) as Observable<Array<string>>
  }
  getTickerSummary(ticker:string){
    return this.http.get(this.tickerUrl + `?ticker=${ticker}`) as Observable<TickerSummary>
  }
}
