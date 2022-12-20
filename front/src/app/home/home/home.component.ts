import { HttpClient } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HomeService } from '../../service/home.service';
import jwt_decode from 'jwt-decode';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  data: any = [];
  breakpoint: number=0;
  list: any=[];
  datas: string[]=["hola", "como", "estas", "hoy", "soy", "data", "para", "imprimir"];
  constructor(private service: HomeService, private router: Router) { }

  getList(){
    this.service.getElements().subscribe(
      store => this.data = store);
      console.log(this.data)
  }
  ngOnInit() {
    this.breakpoint = (window.innerWidth <= 500) ? 1 : 6;
    this.getList();
  }

  onResize(event: any) {
    this.breakpoint = (event.target.innerWidth <= 500) ? 1 : 6;
  }

  redirect(id: string) {
    let token = localStorage.getItem('token')
    
    if(token != null) {
      let storeId = this.getStoreId(token);
      if (id === storeId) {
        this.router.navigate(['menu/edit/'+storeId]);
      }else {
        this.router.navigate(['menu/'+id]);
      }
    }else{
      this.router.navigate(['menu/'+id]);
    }
    
  }

  getStoreId(token: string) {
    const tokenInfo = this.getDecodedAccessToken(token); // decode token
    const storeId = tokenInfo.storeId;
    return storeId;
  }

  getDecodedAccessToken(token: string): any {
    try {
      localStorage.setItem('token', token);
      return jwt_decode(token);
    } catch(Error) {
      return null;
    }
  }
}