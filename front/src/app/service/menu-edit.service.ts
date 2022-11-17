import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Root } from '../models/menu.model';
const API_URL =`${environment.apiUrl}`;

@Injectable()
export class MenuEditService {

  constructor(private http: HttpClient) { }

  getElements(id: string): Observable<Root>{
    console.log(id);
    return this.http.get<Root>(API_URL+"/store/menu/"+id);
  }
}
