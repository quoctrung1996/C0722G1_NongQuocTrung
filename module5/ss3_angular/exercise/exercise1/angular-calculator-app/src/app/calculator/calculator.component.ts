import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  number1:number;
  number2:number;
  calculation:string;
  result:number;


  constructor() { }
  calculator(){
    switch (this.calculation){
      case "+":
        this.result= this.number1+this.number2;
        break;
      case "-":
        this.result= this.number1-this.number2;
        break;
      case "*":
        this.result= this.number1*this.number2;
        break;
      case "/":
        this.result= this.number1/this.number2;
        break;
      default:
        return 0;
    }
  }

  ngOnInit(): void {
  }

}
