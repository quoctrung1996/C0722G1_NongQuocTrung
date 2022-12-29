import { Injectable } from '@angular/core';
import {IWord} from "./i-word";
import {element} from "protractor";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  iWords:IWord[]=[
    {id:1,word:'one',mean:'một'},
    {id:2,word:'two',mean:'hai'},
    {id:3,word:'three',mean:'ba'},
    ]

  constructor() { }
  getAll(){
    return this.iWords;
  }
  findById(id:number):IWord{
    let iWord=this.iWords.filter(element => element.id===id);
    return iWord[0];
  }
}
