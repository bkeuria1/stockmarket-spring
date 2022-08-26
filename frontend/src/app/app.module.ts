import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TradeHistoryComponent } from './trade-history/trade-history.component';
import { BuyAndSellComponent } from './buy-and-sell/buy-and-sell.component';
import { AccountStatusComponent } from './account-status/account-status.component';

import {HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    TradeHistoryComponent,
    BuyAndSellComponent,
    AccountStatusComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
