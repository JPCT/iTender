import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { CreateCategoryRequest } from '../models/category.model';
const API_URL =`${environment.apiUrl}`;

@Injectable()
export class CategoryService {

  constructor(private http: HttpClient) { }

  create(request: CreateCategoryRequest): Observable<any>{
    return this.http.post(API_URL+"/category/product", JSON.stringify(request));
  }
}