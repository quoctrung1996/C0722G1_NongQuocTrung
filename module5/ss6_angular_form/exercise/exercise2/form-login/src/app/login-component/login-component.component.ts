import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {
  contactForm:FormGroup;

  // get contactFormValue(){
  //   return this.contactForm.controls;
  // }

  get email() {
    return this.contactForm.controls.email;
  }

  get password() {
    return this.contactForm.controls.password;
  }


  constructor() {
    this.contactForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.pattern("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])
    })
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.contactForm.value);
  }
}
