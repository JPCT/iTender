import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
//const API_URL_HOME =`${environment.apiUrl}/home`;

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient) { }

  getElements(){
    return this.http.get<any>("localhost:8080/api/store/all",
      {
        headers: new HttpHeaders({
        "content-type":"application/json"
        })
      });
  }
}
