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
import { MatCardModule } from '@angular/material/card';

@NgModule({
  declarations: [
    AppComponent, MenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule, 
    HttpClientModule,
    MatToolbarModule,
    MatCardModule
  ],
  exports:[
    MatToolbarModule
  ],
  providers: [HomeService, MenuService],
  bootstrap: [AppComponent]
})
export class AppModule { }
