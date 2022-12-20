import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Root } from '../models/menu.model';
const API_URL =`${environment.apiUrl}`;

@Injectable()
export class MenuEditService {

  constructor(private http: HttpClient) { }

  getElements(id: string): Observable<Root>{
    return this.http.get<Root>(API_URL+"/store/menu/"+id);
  }

  deleteProduct(id: string): Observable<HttpResponse<boolean>>{
    return this.http.delete<boolean>(API_URL+"/product/"+id, {
      observe: 'response'
    });
  }

  deleteCategory(id: string): Observable<HttpResponse<boolean>>{
    return this.http.delete<boolean>(API_URL+"/category/product/"+id, {
      observe: 'response'
    });
  }
}
