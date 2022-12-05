import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list'
import { RegisterComponent } from './register.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatRadioModule } from '@angular/material/radio';
import {MatDatepickerModule} from  '@angular/material/datepicker';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatCheckboxModule} from '@angular/material/checkbox';

@NgModule({
  declarations: [
    RegisterComponent
  ],
  imports: [
    CommonModule,
    MatGridListModule,
    MatToolbarModule,
    MatCardModule,
    MatFormFieldModule,
    MatRadioModule,
    MatDatepickerModule,
    FormsModule,
    ReactiveFormsModule,
    MatCheckboxModule
  ],
})
export class RegisterModule { }
