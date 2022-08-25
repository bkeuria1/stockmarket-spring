import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { SummaryService } from '../summary.service';
import { TickerSummary } from '../tickerSummary';

@Component({
  selector: 'app-account-status',
  templateUrl: './account-status.component.html',
  styleUrls: ['./account-status.component.css']
})
export class AccountStatusComponent implements OnInit {
  tickers!:Array<string>;
  tickerSummaries: Array<TickerSummary> =[]
  constructor(private service: SummaryService) {
   this.service.getTickers().subscribe(result=>{
      this.tickers = result

      this.tickers.forEach(ticker =>{
        console.log(ticker)
        let summary:Observable<TickerSummary> = this.service.getTickerSummary(ticker)
        console.log(summary)
        // let sampleSummary = new TickerSummary("AAPL",30,1000,150,20)
        // this.tickerSummaries.push(sampleSummary)
        summary.subscribe(result2=>{
          console.log(result2)
         

          this.tickerSummaries.push(result2)
        
        })
        
      })
    })

    
   
   }

  ngOnInit(): void {
    
  }

}
