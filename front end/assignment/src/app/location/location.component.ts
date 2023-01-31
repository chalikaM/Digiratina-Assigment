import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.scss']
})
export class LocationComponent implements OnInit {

  LocationArray : any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;

  headers: HttpHeaders | undefined;
  

  constructor(private http: HttpClient) { 

    this.headers = new HttpHeaders({'Content-Type': 'application/json;'})
    this.getAllLocations();
  }

  ngOnInit(): void {
  }

  getAllLocations()
  {

    console.log("gell parcels")
    
    this.http.get("http://localhost:8081/api/assignment/get/locations")
  
    .subscribe((resultData: any)=>
    {
        this.isResultLoaded = true;
        console.log(resultData);
        this.LocationArray = resultData;
    });
  }

}
