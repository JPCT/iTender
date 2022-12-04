import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs/internal/Subscription';
import { LoginRequest, LoginResponse } from '../models/login.model';
import { Root } from '../models/menu.model';
import { LoginService } from '../service/login.service';
import jwt_decode from 'jwt-decode';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  breakpoint: number=0;
  username!: string;
  password!: string;
  errorMessage: string = '';
  logged: boolean = false;
  request: LoginRequest = {
    username: '',
    password: ''
  }
  response!: LoginResponse;
  private routeSub: Subscription = new Subscription;
  constructor(private service: LoginService, private router: Router) { }

  doLogin(){
    this.request.username = this.username;
    this.request.password = this.password;
    this.errorMessage = '';

    this.service.login(this.request).subscribe({
      next: data => {
        console.log(data);
        this.response = data;
        var storeId = this.getStoreId(data.access_token);
        if (storeId){
          this.redirect(storeId);
        } else {
          this.redirectHome();
        }
      },
      error: error => {
          this.errorMessage = 'Credenciales inválidas.';
          console.log('There was an error!', error);
      }
    })
    console.log(this.response);
  }
  ngOnInit() {
    this.breakpoint = (window.innerWidth <= 500) ? 1 : 6;
  }

  onResize(event: any) {
    this.breakpoint = (event.target.innerWidth <= 500) ? 1 : 6;
  }

  ngOnDestroy() {
    this.routeSub.unsubscribe();
  }

  login() {
    this.doLogin();
  }

  getDecodedAccessToken(token: string): any {
    try {
      localStorage.setItem('token', token);
      return jwt_decode(token);
    } catch(Error) {
      return null;
    }
  }

  redirect(storeId: string) {
    this.router.navigate(['menu/edit/'+storeId]);
  }

  redirectHome() {
    this.router.navigate(['home']);
  }

  getStoreId(token: string) {
    const tokenInfo = this.getDecodedAccessToken(token); // decode token
    const storeId = tokenInfo.storeId;
    return storeId;
  }

}