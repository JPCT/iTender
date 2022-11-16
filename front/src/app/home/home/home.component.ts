import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HomeService } from '../../service/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  data: any = [];
  breakpoint: number=0;
  list: any=[];
  datas: string[]=["hola", "como", "estas", "hoy", "soy", "data", "para", "imprimir"];
  constructor(private service: HomeService, private router: Router) { }

  getList(){
    this.service.getElements().subscribe(
      store => this.data = store);
      console.log(this.data)
  }
  ngOnInit() {
    this.breakpoint = (window.innerWidth <= 500) ? 1 : 6;
    this.getList();
  }

  onResize(event: any) {
    this.breakpoint = (event.target.innerWidth <= 500) ? 1 : 6;
  }

  redirect(id: string) {
    this.router.navigate(['menu/'+id]);
  }

}