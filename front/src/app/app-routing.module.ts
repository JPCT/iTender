import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home/home.component';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { ProductCreateComponent } from './product/product-create/product-create.component';
import { RegisterComponent } from './register/register.component';
import { MenuEditComponent } from './menu-edit/menu-edit.component';
import { CategoryCreateComponent } from './category/category-create.component';

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
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'menu/edit/:id',
    component: MenuEditComponent
  },
  {
    path: 'product/create/:storeId/:categoryId',
    component: ProductCreateComponent
  },
  {
    path: 'category/create/:storeId',
    component: CategoryCreateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
