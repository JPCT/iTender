import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs/internal/Subscription';
import { CreateProductRequest } from 'src/app/models/product.model';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  breakpoint: number=0;
  errorMessage: string = '';
  response!: String
  request: CreateProductRequest = {
      name: '',
      price: 0,
      description: '',
      productCategoryId: '',
      storeId: '',
      image: new File([""], "filename"),
  }
  storeId: string = "";
  categoryId: string = "";
  private routeSub: Subscription = new Subscription;
  fileName: string = "";
  http: any;
  constructor(private service: ProductService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.breakpoint = (window.innerWidth <= 500) ? 1 : 6;
    this.routeSub = this.route.params.subscribe(params => {
      this.storeId = params['storeId'];
      this.categoryId = params['categoryId'];
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
          this.errorMessage = 'No se pudo crear el producto.';
          console.log('There was an error!', error);
      }
    })
  }

  redirect() {
    this.router.navigate(['menu/edit/'+this.storeId]);
  }

  create() {
    this.request.storeId = this.storeId;
    this.request.productCategoryId = this.categoryId;
    this.doCreate();
  }

  onFileSelected(event: Event) {
    const target = event.target as HTMLInputElement;
    const files = target.files as FileList;
    this.request.image = files[0];
    this.fileName = this.request.image.name;
}

}