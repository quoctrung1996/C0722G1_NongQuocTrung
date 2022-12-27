import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-ratin-bar-component',
  templateUrl: './ratin-bar-component.component.html',
  styleUrls: ['./ratin-bar-component.component.css']
})
export class RatinBarComponentComponent implements OnInit {
@Input("ratingStar") ratingStar:number=0;
  constructor() { }

  ngOnInit(): void {
  }

}
