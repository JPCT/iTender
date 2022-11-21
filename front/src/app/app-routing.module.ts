import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home/home.component';
import { LoginComponent } from './login/login.component';
import { MenuEditComponent } from './menu-edit/menu-edit.component';
import { MenuComponent } from './menu/menu.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {
    path:'home',
    component: HomeComponent
  },
  {
    path: 'menu/:id',
    component: MenuComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'menu/edit/:id',
    component: MenuEditComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
