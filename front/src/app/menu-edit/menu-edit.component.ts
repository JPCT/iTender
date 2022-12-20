import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs/internal/Subscription';
import { Root } from '../models/menu.model';
import { MenuEditService } from '../service/menu-edit.service';

@Component({
  selector: 'app-menu-edit',
  templateUrl: './menu-edit.component.html',
  styleUrls: ['./menu-edit.component.css']
})
export class MenuEditComponent implements OnInit {
  data!: Root;
  breakpoint: number=0;
  storeId: string = "";
  private routeSub: Subscription = new Subscription;
  constructor(private service: MenuEditService, private route: ActivatedRoute, private router: Router) { }

  getMenu(){
    this.service.getElements(this.storeId).subscribe(
      res => {
        this.data = res;
      });
  }
  ngOnInit() {
    this.breakpoint = (window.innerWidth <= 500) ? 1 : 6;
    this.routeSub = this.route.params.subscribe(params => {
      //console.log(params['id']) //log the value of id
      this.storeId = params['id'];
    });
    this.getMenu();
  }

  onResize(event: any) {
    this.breakpoint = (event.target.innerWidth <= 500) ? 1 : 6;
  }

  ngOnDestroy() {
    this.routeSub.unsubscribe();
  }

  redirect() {
    this.router.navigate(['home/']);
  }

  delete(id: string) {
    this.service.deleteProduct(id).subscribe(response => {
      if (response.status === 204) {
        this.ngOnInit();
      }
    });
  }

  deleteCategory(id: string) {
    this.service.deleteCategory(id).subscribe(response => {
      if (response.status === 204) {
        this.ngOnInit();
      }
    });
  }

  create(id: string) {
    this.router.navigate(['product/create/'+this.storeId+'/'+id]);
  }

  createCategory(id: string) {
    this.router.navigate(['category/create/'+this.storeId]);
  }

}