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
import { MenuEditService } from './service/menu-edit.service';
import { MenuEditComponent } from './menu-edit/menu-edit.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { JwtInterceptor } from './service/jwtinterceptor.service';
import { ProductService } from './service/product.service';
import { ProductCreateComponent } from './product/product-create/product-create.component';
import { CategoryCreateComponent } from './category/category-create.component';
import { CategoryService } from './service/category.service';


@NgModule({
  declarations: [
    AppComponent, MenuComponent, LoginComponent, RegisterComponent, MenuEditComponent, ProductCreateComponent, CategoryCreateComponent
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
    MatRadioModule
  ],
  exports:[
    MatToolbarModule
  ],
  providers: [HomeService, MenuService, LoginService, RegisterService, MenuEditService, ProductService, CategoryService, { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },],
  bootstrap: [AppComponent]
})
export class AppModule { }
