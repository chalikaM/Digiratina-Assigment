import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompanyComponent } from './company/company.component';
import { LocationComponent } from './location/location.component';
import { ParcelRegistrationComponent } from './parcel-registration/parcel-registration.component';
import { ParcelComponent } from './parcel/parcel.component';

const routes: Routes = [
  {path:'' , pathMatch:'full', redirectTo:'parcels'},
  {path:'parcels', component: ParcelComponent},
  {path:'companies', component: CompanyComponent},
  {path:'locations', component: LocationComponent},
  {path:'parcelRegistrations', component: ParcelRegistrationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
