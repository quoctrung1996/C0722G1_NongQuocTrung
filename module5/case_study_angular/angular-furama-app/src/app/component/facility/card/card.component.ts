import {Component, OnInit} from '@angular/core';
import {Facility} from '../../../model/facility/facility';
import {FacilityType} from '../../../model/facility/facility-type';
import {RentType} from '../../../model/facility/rent-type';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  facilityTypes: FacilityType[] = [
    {id: 1, name: 'Villa'},
    {id: 2, name: 'House'},
    {id: 3, name: 'Room'}
  ];
  rentTypes: RentType[] = [
    {id: 1, name: 'year'},
    {id: 2, name: 'month'},
    {id: 3, name: 'day'},
    {id: 4, name: 'hour'}
  ];
  facilitys: Facility[] = [
    {
      id: 1,
      name: 'House Princess ',
      area: 14000,
      cost: 500,
      maxPeople: 7,
      standardRoom: 'vip',
      desciption: 'Có thêm bếp nướng',
      numberOfFloors: 3,
      facilityType: this.facilityTypes[1],
      rentType:this.rentTypes[1]
    },
    {
      id: 2,
      name: 'Room Twin 01 ',
      area: 5000,
      cost: 100,
      maxPeople: 2,
      standardRoom: 'normal',
      desciption: 'Có tivi',
      facilityFree:"1 Xe máy, 1 Xe đạp",
      facilityType: this.facilityTypes[2],
      rentType:this.rentTypes[3]
    },

    {
      id: 3,
      name: 'Villa No Beach Front ',
      area: 22000,
      cost: 900,
      maxPeople: 8,
      standardRoom: 'normal',
      desciption: 'Có hồ bơi',
      poolArea:300,
      numberOfFloors: 3,
      facilityType: this.facilityTypes[0],
      rentType:this.rentTypes[2]
    },
    {
      id: 4,
      name: 'House Princess 02',
      area: 10000,
      cost: 400,
      maxPeople: 5,
      standardRoom: 'normal',
      desciption: 'Có thêm bếp nướng',
      numberOfFloors: 2,
      facilityType: this.facilityTypes[1],
      rentType:this.rentTypes[2]
    },
    {
      id: 5,
      name: 'Room Twin 02',
      area: 3000,
      cost: 300,
      maxPeople: 2,
      standardRoom: 'normal',
      desciption: 'Có tivi',
      facilityFree:"1 xe máy",
      facilityType: this.facilityTypes[2],
      rentType:this.rentTypes[3]
    }
  ];

  constructor() {
  };

  ngOnInit(): void {

  }
}
