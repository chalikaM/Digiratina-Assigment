import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parcel-registration',
  templateUrl: './parcel-registration.component.html',
  styleUrls: ['./parcel-registration.component.scss']
})
export class ParcelRegistrationComponent implements OnInit {

  ParcelArray : any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;


  senderName: string ="";
  receiverName: string ="";
  locationId: Number =0;
  companyId: Number =0;

  headers: HttpHeaders | undefined;
  

  constructor(private http: HttpClient) { 

    this.headers = new HttpHeaders({'Content-Type': 'application/json;'})

  }

  ngOnInit(): void {
  }

  save()
  {

    console.log("register"); 
    let bodyData = {
      "senderName" : this.senderName,
      "receiverName" : this.receiverName,
      "locationId" : this.locationId,
      "companyId" : this.companyId
    };

    this.http.post("http://localhost:8081/api/assignment/create",bodyData,{headers: this.headers}).subscribe((resultData: any)=>
    {

      console.log(resultData);
      alert("Employee Registered Successfully");
 
      this.senderName = '';
      this.receiverName = '';
      this.locationId  = 0;
      this.companyId  = 0;

    });
    
    
  }
}
