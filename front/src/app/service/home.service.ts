import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { StoreModel } from '../models/store.model';
import { Observable } from 'rxjs';
//const API_URL_HOME =`${environment.apiUrl}/home`;

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient) { }

  getElements(){
    return this.http.get<any>("http://localhost:8082/store/all",
      {
        headers: new HttpHeaders({
        "content-type":"text/html",
        "Access-Control-Allow-Origin": "*"
        }),
      });
  }

  getStores(): Observable<StoreModel[]> {
    return this.http.get<StoreModel[]>("http://localhost:8082/store/all",
    {
      headers: new HttpHeaders({
      "content-type":"application/json",
      "Access-Control-Allow-Origin": "http://localhost:8080/store/all",
      })
    });
  }
}
