import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.scss']
})
export class CompanyComponent implements OnInit {

  companyArray : any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;

  headers: HttpHeaders | undefined;
  

  constructor(private http: HttpClient) { 

    this.headers = new HttpHeaders({'Content-Type': 'application/json;'})
    this.getAllCompanies();
  }

  ngOnInit(): void {
  }

  getAllCompanies()
  {

    console.log("gell parcels")
    
    this.http.get("http://localhost:8081/api/assignment/get/companies")
  
    .subscribe((resultData: any)=>
    {
        this.isResultLoaded = true;
        console.log(resultData);
        this.companyArray = resultData;
    });
  }

}
