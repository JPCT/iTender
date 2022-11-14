import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
const API_URL =`${environment.apiUrl}`;

@Injectable()
export class MenuService {

  constructor(private http: HttpClient) { }

  getElements(id: string): Observable<any>{
    console.log(id);
    return this.http.get<any>(API_URL+"/store/menu/"+id);
  }
}
