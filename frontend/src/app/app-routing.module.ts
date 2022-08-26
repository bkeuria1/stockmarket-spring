import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountStatusComponent } from './account-status/account-status.component';
import { BuyAndSellComponent } from './buy-and-sell/buy-and-sell.component';
import { HomeComponent } from './home/home.component';
import { TradeHistoryComponent } from './trade-history/trade-history.component';

const routes: Routes = [{path:"home", component: HomeComponent},
                        {path:"account-status", component: AccountStatusComponent},
                        {path:"buy-and-sell",component: BuyAndSellComponent},
                        {path:"trade-history", component: TradeHistoryComponent},
                        {path:'**',redirectTo:'/home',pathMatch:'full'}
                        ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
