import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo1',
  templateUrl: './demo1.component.html',
  styleUrls: ['./demo1.component.css']
})
export class Demo1Component implements OnInit {

  color: string="red";
  constructor() {
  }

  ngOnInit(): void {
  }

  changeName(target: any) {
    this.color=target.value;
  }
}
