import { Component, OnInit } from '@angular/core';
import {IWord} from "../i-word";
import {DictionaryService} from "../dictionary.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-dictionay-page',
  templateUrl: './dictionay-page.component.html',
  styleUrls: ['./dictionay-page.component.css']
})
export class DictionayPageComponent implements OnInit {
  iWords:IWord[]=[];
  constructor(private dictionaryService:DictionaryService,private router:Router) {
    this.iWords=this.dictionaryService.getAll();
  }

  ngOnInit(): void {
  }

}
