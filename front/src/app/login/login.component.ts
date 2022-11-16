import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs/internal/Subscription';
import { LoginRequest, LoginResponse } from '../models/login.model';
import { Root } from '../models/menu.model';
import { LoginService } from '../service/login.service';

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
        this.redirect();
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

  redirect() {
    this.router.navigate(['home/']);
  }

}