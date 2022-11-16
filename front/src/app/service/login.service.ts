import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Root } from '../models/menu.model';
import { LoginRequest, LoginResponse } from '../models/login.model';
const API_URL =`${environment.apiUrl}`;

@Injectable()
export class LoginService {

  constructor(private http: HttpClient) { }

  login(request: LoginRequest): Observable<LoginResponse>{
    return this.http.post<LoginResponse>(API_URL+"/login", JSON.stringify(request));
  }
}
