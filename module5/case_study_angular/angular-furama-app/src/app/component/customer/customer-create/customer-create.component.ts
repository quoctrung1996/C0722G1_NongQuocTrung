import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../../../model/customer/customer-type';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  contactForm: FormGroup;
  customerTypes: CustomerType[] = [
    {id: 1, name: 'Diamond'},
    {id: 2, name: 'Platinium'},
    {id: 3, name: 'Gold'},
    {id: 4, name: 'Silver'},
    {id: 5, name: 'Member'},
  ];

  constructor() {
    this.contactForm = new FormGroup({
      id: new FormControl('', [Validators.required]),
      code: new FormControl('', [Validators.required, Validators.pattern('^KH-[0-9]{4}$')]),
      name: new FormControl('', [Validators.required, Validators.pattern('^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$')]),
      dateOfBirth: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      idCard: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{9}|[0-9]{12}$')]),
      phoneNumber: new FormControl('', [Validators.required, Validators.pattern('^090[0-9]{7}|091[0-9]{7}|\\+8490[0-9]{7}|\\+8491[0-9]{7}')]),
      email: new FormControl('', [Validators.required, Validators.pattern('^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$')]),
      address: new FormControl('', [Validators.required]),
      customerType: new FormControl('', [Validators.required])
    });
  }

  get contactFormValue(){
    return this.contactForm.controls;
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.contactForm.value);
  }
}
