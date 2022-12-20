import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs/internal/Subscription';
import { Root } from '../models/menu.model';
import { MenuService } from '../service/menu.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  data!: Root;
  breakpoint: number=0;
  storeId: string = "";
  private routeSub: Subscription = new Subscription;
  constructor(private service: MenuService, private route: ActivatedRoute, private router: Router) { }

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

}