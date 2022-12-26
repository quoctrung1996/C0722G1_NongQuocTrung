import {Customer} from '../customer/customer';
import {Facility} from '../facility/facility';

export interface Contract {
  id:number;
  startDate:string;
  endDate:string;
  deposit:number;
  customer?:Customer;
  customerDemo:string;
  facility?:Facility;
  facilityDemo:string;
}
