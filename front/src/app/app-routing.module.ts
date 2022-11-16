import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home/home.component';
import { MenuComponent } from './menu/menu.component';

const routes: Routes = [
  {path:'home',
component: HomeComponent},
  {
    path: 'menu/:id',
    component: MenuComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
