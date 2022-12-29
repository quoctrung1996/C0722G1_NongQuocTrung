import { Component, OnInit } from '@angular/core';
import {IWord} from "../i-word";
import {ActivatedRoute} from "@angular/router";
import {DictionaryService} from "../dictionary.service";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  iWord:IWord|undefined;
  constructor(
    private activatedRoute:ActivatedRoute,
    private dictionaryService:DictionaryService
  ) {

  }

  ngOnInit(): void {
    let index=this.activatedRoute.snapshot.params['id'];
    this.iWord=this.dictionaryService.findById(parseInt(index));
  }

}
