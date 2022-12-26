import {Component, OnInit} from '@angular/core';
import {Customer} from '../../../model/customer/customer';
import {Facility} from '../../../model/facility/facility';
import {Contract} from '../../../model/contract/contract';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {

  contracts: Contract[] = [
    {id: 1, startDate: '2020-12-08', endDate: '2020-12-08', deposit: 200000, customerDemo:'Nguyễn Thị Hào' , facilityDemo:'House Princess ' },
    {id: 2, startDate: '2021-11-20', endDate: '2022-12-12', deposit: 100000, customerDemo: 'Phạm Xuân Diệu', facilityDemo: 'Room Twin 01'},
    {id: 3, startDate: '2021-05-08', endDate: '2022-03-01', deposit: 300000, customerDemo: 'Trương Đình Nghệ', facilityDemo: 'Villa No Beach Front '},
    {id: 4, startDate: '2020-03-08', endDate: '2021-10-23', deposit: 400000, customerDemo: 'Dương Văn Quan', facilityDemo: 'House Princess 02'},
    {id: 5, startDate: '2018-12-08', endDate: '2019-07-08', deposit: 500000, customerDemo: 'Hoàng Trần Nhi Nhi', facilityDemo: 'Room Twin 02 '},
  ];

  constructor() {
  }

  ngOnInit(): void {
  }

}
