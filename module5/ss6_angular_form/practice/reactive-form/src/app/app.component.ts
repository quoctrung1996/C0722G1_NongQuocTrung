import { Component } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  countryList=[
    {id:1,name:'VN'},
    {id:2,name:'JP'}
  ]
  title = 'reactive-form';
  contactForm=new FormGroup({
    name:new FormControl(),
    age:new FormControl(),
    gender:new FormControl(),
    country:new FormControl(),
    address:new FormGroup({
      city:new FormControl(),
      street:new FormControl()
    })
  });

  onSubmit() {
    console.log(this.contactForm.value);

  }
}
