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
    gender!: String;
    breakpoint: number=0;
    errorMessage: string = '';
    response!: String
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
      
      this.service.register(this.request).subscribe({
        next: data => {
          console.log(data);
          this.response = data;
          this.redirect();
        },
        error: error => {
            this.errorMessage = 'No se pudo registrar el usuario.';
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
  
    register() {
      this.doRegister();
    }
  
    redirect() {
      this.router.navigate(['home/']);
    }
  
  }