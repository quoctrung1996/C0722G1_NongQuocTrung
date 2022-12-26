import {Component, OnInit} from '@angular/core';


@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
  color1: boolean;
  color2: boolean;
  color3: boolean;
  img1:string;
  img2:string;
  img3:string;

  constructor() {
  }

  choiseColor(){

    if (this.color1==true){
      this.img1="red";
    }
    if (this.color2==true){
      this.img2="blue";
    }
    if (this.color3==true){
      this.img3="yellow";
    }
  }

  ngOnInit(): void {
  }

}

