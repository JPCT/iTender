import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { CreateUserRequest } from '../models/register.model';
const API_URL =`${environment.apiUrl}`;

@Injectable()
export class RegisterService {

  constructor(private http: HttpClient) { }

  register(request: CreateUserRequest): Observable<String>{
    return this.http.post<String>(API_URL+"/user/save", JSON.stringify(request));
  }
}
