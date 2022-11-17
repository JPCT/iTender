import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeModule } from './home/home/home.module';

import {MatToolbarModule} from '@angular/material/toolbar';
import { HttpClientModule } from '@angular/common/http';
import { HomeService } from './service/home.service';
import { MenuService } from './service/menu.service';
import { MenuComponent } from './menu/menu.component';
import { RegisterService } from './service/register.service'
import { RegisterComponent } from './register/register.component';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { LoginComponent } from './login/login.component';
import { LoginService } from './service/login.service';
import { FormsModule } from '@angular/forms';
import { MatNativeDateModule } from '@angular/material/core';
import { MatListModule } from '@angular/material/list';
import { MatDatepickerModule } from '@angular/material/datepicker';
import {MatIconModule} from '@angular/material/icon';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';


@NgModule({
  declarations: [
    AppComponent, MenuComponent, LoginComponent, RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule, 
    HttpClientModule,
    MatToolbarModule,
    MatCardModule,
    MatButtonModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatIconModule,
    MatButtonModule,
    MatCheckboxModule,
    MatToolbarModule,
    FormsModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatListModule,
    MatRadioModule,
  ],
  exports:[
    MatToolbarModule
  ],
  providers: [HomeService, MenuService, LoginService, RegisterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
