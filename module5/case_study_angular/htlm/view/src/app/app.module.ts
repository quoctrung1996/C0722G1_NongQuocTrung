import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { CardComponent } from './component/facility/card/card.component';
import { FacilityEditComponent } from './component/facility/facility-edit/facility-edit.component';
import { FacilityCreateComponent } from './component/facility/facility-create/facility-create.component';
import { CustomerEditComponent } from './component/customer/customer-edit/customer-edit.component';
import { CustomerCreateComponent } from './component/customer/customer-create/customer-create.component';
import { CustomerListComponent } from './component/customer/customer-list/customer-list.component';
import { ContractCreateComponent } from './component/contract/contract-create/contract-create.component';
import { ContractListComponent } from './component/contract/contract-list/contract-list.component';

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        FooterComponent,
        HeaderComponent,
        NavbarComponent,
        CardComponent,
        FacilityEditComponent,
        FacilityCreateComponent,
        CustomerEditComponent,
        CustomerCreateComponent,
        CustomerListComponent,
        ContractCreateComponent,
        ContractListComponent,

    ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
