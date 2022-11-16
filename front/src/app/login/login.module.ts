import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list'
import { LoginComponent } from './login.component';




@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    CommonModule,
    MatGridListModule,
    MatToolbarModule,
    MatCardModule
  ],
})
export class MenuModule { }
