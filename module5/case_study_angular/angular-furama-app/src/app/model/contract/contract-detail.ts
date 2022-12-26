import {Contract} from './contract';
import {AttachFacility} from './attach-facility';

export interface ContractDetail {
  id:number;
  quantity:number;
  contract:Contract;
  attachFacility: AttachFacility
}
