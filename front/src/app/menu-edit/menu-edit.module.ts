import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list'
import { MenuEditComponent } from './menu-edit.component';
import {MatIconModule} from '@angular/material/icon'



@NgModule({
  declarations: [
    MenuEditComponent
  ],
  imports: [
    CommonModule,
    MatGridListModule,
    MatToolbarModule,
    MatCardModule,
    MatIconModule
  ],
})
export class MenuEditModule { }
