import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Trade } from '../trade';
import { TradeServiceService } from '../trade-service.service';

@Component({
  selector: 'app-trade-history',
  templateUrl: './trade-history.component.html',
  styleUrls: ['./trade-history.component.css']
})
export class TradeHistoryComponent implements OnInit {
  trades:Observable<Array<Trade>>;

  constructor(private service:TradeServiceService) {
    this.trades = service.getTrades();
   }

  ngOnInit(): void {
  }

}
