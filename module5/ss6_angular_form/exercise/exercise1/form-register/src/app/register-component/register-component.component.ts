import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register-component',
  templateUrl: './register-component.component.html',
  styleUrls: ['./register-component.component.css']
})
export class RegisterComponentComponent implements OnInit {
  countryList=[
    {id:1,name:'Viet Nam'},
    {id:2,name:'JaPan'}
  ]
  contactForm=new FormGroup({
    email:new FormControl('',[Validators.required,Validators.pattern("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")]),
    password:new FormControl('',[Validators.required,Validators.minLength(6)]),
    confirmPassword:new FormControl('',[Validators.required,Validators.minLength(6)]),
    country:new FormControl('',[Validators.required]),
    age:new FormControl('',[Validators.min(18),Validators.required]),
    gender:new FormControl('',[Validators.required]),
    phone:new FormControl('',[Validators.required,Validators.pattern("^\\+84\\d{9,10}$")]),
  });
  get contactFormValue(){
    return this.contactForm.controls;
    //controls:lấy ra tất cả giá trị của thuộc tính
  }
  // get email() {
  //   return this.contactForm.get('email');
  // }
  // get country() {
  //   return this.contactForm.get('country');
  // }
  // get age() {
  //   return this.contactForm.get('age');
  // }
  // get gender() {
  //   return this.contactForm.get('gender');
  // }
  // get phone() {
  //   return this.contactForm.get('phone');
  // }
  // get password() {
  //   return this.contactForm.get('password');
  // }
  // get confirmPassword() {
  //   return this.contactForm.get('confirmPassword');
  // }
  // onPasswordChange() {
  //   if (this.contactFormValue.confirmPassword.value == this.contactFormValue.password.value ) {
  //     // @ts-ignore
  //     this.contactFormValue.confirmPassword.value(null);
  //   } else {
  //     // @ts-ignore
  //     this.contactFormValue.confirmPassword.value({ mismatch: true });
  //   }
  // }
  onPasswordChange() {
    if (this.contactFormValue.confirmPassword.value == this.contactFormValue.password.value) {
      this.contactFormValue.confirmPassword.setErrors(null);
    } else {
      this.contactFormValue.confirmPassword.setErrors({ mismatch: true });
    }
  }

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.contactForm.value);
  }

}
