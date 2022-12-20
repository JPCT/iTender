import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'iTender';
  logged = false;

  constructor(private router: Router) {
    let token = localStorage.getItem('token')
    
    if(token != null) {
      this.logged = true;
    }
   }

  redirect() {
    this.router.navigate(['login/']);
  }
}

