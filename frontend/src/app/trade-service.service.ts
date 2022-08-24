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
}
