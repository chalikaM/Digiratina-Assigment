import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-parcel',
  templateUrl: './parcel.component.html',
  styleUrls: ['./parcel.component.scss']
})
export class ParcelComponent implements OnInit {

  ParcelArray : any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;


  senderName: string ="";
  receiverName: string ="";
  locationId: Number =0;
  companyId: Number =0;

  headers: HttpHeaders | undefined;
  

  constructor(private http: HttpClient, private router:Router) { 

    this.headers = new HttpHeaders({'Content-Type': 'application/json;'})
    this.getAllCustomer();
  }

  ngOnInit(): void {
  }

  // save()
  // {
  //   this.register();  
  //   console.log("saved");   
  // }

  // register()
  // {
  //   console.log("register"); 
  //   let bodyData = {
  //     "senderName" : this.senderName,
  //     "receiverName" : this.receiverName,
  //     "locationId" : this.locationId,
  //     "companyId" : this.companyId
  //   };

  //   this.http.post("http://localhost:8081/api/assignment/create",bodyData,{headers: this.headers}).subscribe((resultData: any)=>
  //   {

  //     console.log(resultData);
  //     alert("Employee Registered Successfully");
  //     this.getAllCustomer();
 
  //     this.senderName = '';
  //     this.receiverName = '';
  //     this.locationId  = 0;
  //     this.companyId  = 0;

  //   });
  // }

  getAllCustomer()
  {

    console.log("gell parcels")
    
    this.http.get("http://localhost:8081/api/assignment/get/parcels")
  
    .subscribe((resultData: any)=>
    {
        this.isResultLoaded = true;
        console.log(resultData);
        this.ParcelArray = resultData;
    });
  }

  navigateCreateNewParcelsScreen(){
    this.router.navigate(['parcelRegistrations']);
  }

}
