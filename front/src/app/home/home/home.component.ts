import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/service/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  data = [{
    id: 1,
    name:"cafe",
    description:"cafesss",
    logoUrl:"https://pbs.twimg.com/profile_images/949787136030539782/LnRrYf6e_400x400.jpg"
},
{
    id: 2,
    name:"cafe 2",
    description:"cafesss 2",
    logoUrl:"https://www.boredpanda.com/blog/wp-content/uploads/2017/12/funny-weird-wtf-stock-photos-19-5a3926af95d9d__700.jpg"
},
{
    id: 3,
    name:"cafe 3",
    description:"cafesss 3",
    logoUrl:"https://iso.500px.com/wp-content/uploads/2015/03/business_cover.jpeg"
}]
  breakpoint: number=0;
  list: any=[];
  datas: string[]=["hola", "como", "estas", "hoy", "soy", "data", "para", "imprimir"];
  constructor(/*private service: HomeService*/) { }

  /*getList(){
    this.service.getElements().subscribe(
      data=>{this.list= this.data;}
      
      )
  }*/
  ngOnInit() {
    this.breakpoint = (window.innerWidth <= 500) ? 1 : 6;
  }
  
  onResize(event: any) {
    this.breakpoint = (event.target.innerWidth <= 500) ? 1 : 6;
  }


}