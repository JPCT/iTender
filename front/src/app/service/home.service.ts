import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
const API_URL =`${environment.apiUrl}`;

@Injectable()
export class HomeService {

  constructor(private http: HttpClient) { }

  getElements(){
    return this.http.get<any>(API_URL+"/store/all");
  }
}
