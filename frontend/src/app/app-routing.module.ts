import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountStatusComponent } from './account-status/account-status.component';
import { BuyAndSellComponent } from './buy-and-sell/buy-and-sell.component';
import { TradeHistoryComponent } from './trade-history/trade-history.component';

const routes: Routes = [{path:"account-status", component: AccountStatusComponent},
                        {path:"buy-and-sell",component: BuyAndSellComponent},
                        {path:"trade-history", component: TradeHistoryComponent}
                        ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
