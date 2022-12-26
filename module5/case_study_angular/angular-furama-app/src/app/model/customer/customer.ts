import {CustomerType} from './customer-type';

export interface Customer {
  id:number;
  code?:string;
  name:string;
  dateOfBirth:string;
  gender:string;
  idCard:string;
  phoneNumber:string;
  email:string;
  address:string;
  customerType:CustomerType;
}
