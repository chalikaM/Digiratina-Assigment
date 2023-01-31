import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ParcelComponent } from './parcel/parcel.component';
import { HttpClientModule } from '@angular/common/http';
import { ParcelRegistrationComponent } from './parcel-registration/parcel-registration.component';
import { LocationComponent } from './location/location.component';
import { CompanyComponent } from './company/company.component';

@NgModule({
  declarations: [
    AppComponent,
    ParcelComponent,
    ParcelRegistrationComponent,
    LocationComponent,
    CompanyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
