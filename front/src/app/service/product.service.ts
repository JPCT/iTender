import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Root } from '../models/menu.model';
import { CreateProductRequest } from '../models/product.model';
const API_URL =`${environment.apiUrl}`;

@Injectable()
export class ProductService {

  constructor(private http: HttpClient) { }

  create(request: CreateProductRequest): Observable<any>{
    let formData:FormData = new FormData();
    formData.append('name', request.name);
    formData.append('price', request.price.toString());
    formData.append('description', request.description);
    formData.append('image', request.image);
    formData.append('productCategoryId', request.productCategoryId);
    formData.append('storeId', request.storeId);
    return this.http.post(API_URL+"/product", formData);
  }
}