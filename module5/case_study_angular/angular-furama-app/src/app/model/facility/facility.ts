import {FacilityType} from './facility-type';
import {RentType} from './rent-type';

export interface Facility {
  id:number;
  name:string;
  area:number;
  cost:number;
  maxPeople:number;
  standardRoom:string;
  desciption:string;
  poolArea?:number;
  numberOfFloors?:number;
  facilityFree?:string;
  facilityType:FacilityType;
  rentType:RentType;
}
