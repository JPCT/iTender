import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs/internal/Subscription';
import { CreateUserRequest } from '../models/register.model';
import { RegisterService } from '../service/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
    breakpoint: number=0;
    errorMessage: string = '';
    response!: string;
    request: CreateUserRequest = {
        firstName: '',
        lastName: '',
        phoneNumber: '',
        sex: '',
        username: '',
        password: '',
    }
    private routeSub: Subscription = new Subscription;
    constructor(private service: RegisterService, private router: Router) { }
  
    doRegister(){
      console.log(this.request);
      this.service.register(this.request).subscribe({
        next: data => {
          this.response = data;
        },
        error: error => {
            console.log( 'No se pudo registrar el usuario.', error);
        },
        complete: () => {
          this.redirect();
        }
      })
      
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
  
    register() {
      this.doRegister();
    }
  
    redirect() {
      this.router.navigate(['home/']);
    }
  
  }