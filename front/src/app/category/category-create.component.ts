import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs/internal/Subscription';
import { CreateCategoryRequest } from '../models/category.model';
import { CategoryService } from '../service/category.service';

@Component({
  selector: 'app-category-create',
  templateUrl: './category-create.component.html',
  styleUrls: ['./category-create.component.css']
})
export class CategoryCreateComponent implements OnInit {
  breakpoint: number=0;
  errorMessage: string = '';
  response!: String
  request: CreateCategoryRequest = {
      categoryName: '',
      storeId: '',
  }
  storeId: string = "";
  private routeSub: Subscription = new Subscription;
  http: any;
  constructor(private service: CategoryService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.breakpoint = (window.innerWidth <= 500) ? 1 : 6;
    this.routeSub = this.route.params.subscribe(params => {
      this.storeId = params['storeId'];
    });
  }

  onResize(event: any) {
    this.breakpoint = (event.target.innerWidth <= 500) ? 1 : 6;
  }

  ngOnDestroy() {
    this.routeSub.unsubscribe();
  }

  doCreate() {
    this.service.create(this.request).subscribe({
      next: data => {
        this.response = data;
        this.redirect();
      },
      error: error => {
          this.errorMessage = 'No se pudo crear el categoryo.';
          console.log('There was an error!', error);
      }
    })
  }

  redirect() {
    this.router.navigate(['menu/edit/'+this.storeId]);
  }

  create() {
    this.request.storeId = this.storeId;
    this.doCreate();
  }

}