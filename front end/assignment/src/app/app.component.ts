import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(private router:Router) {

  }

  navigateParcels() {
    this.router.navigate(['parcels'])
  }

  navigateCompanies() {
    this.router.navigate(['companies'])
  }

  navigateLocations() {
    this.router.navigate(['locations'])
  }
  title = 'assignment';
}
