import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TradeHistoryComponent } from './trade-history/trade-history.component';
import { BuyAndSellComponent } from './buy-and-sell/buy-and-sell.component';
import { AccountStatusComponent } from './account-status/account-status.component';

import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    TradeHistoryComponent,
    BuyAndSellComponent,
    AccountStatusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
