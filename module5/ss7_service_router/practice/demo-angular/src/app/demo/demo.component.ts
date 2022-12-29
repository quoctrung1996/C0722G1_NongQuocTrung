import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {DemoSerrviceService} from "../demo-serrvice.service";

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {
  // studentDetai:Student|undefined;
  constructor(
    private activatedRoute:ActivatedRoute,
    private demoSerrviceService:DemoSerrviceService)
  {

  }

  ngOnInit(): void {
    let index=this.activatedRoute.snapshot.params['index'] //-->bên routing
    console.log(index);
    // this.studentDetai=this.demoSerrviceService.getStudentByIndex(index);
    // -->Đây là class edit
  }

}
