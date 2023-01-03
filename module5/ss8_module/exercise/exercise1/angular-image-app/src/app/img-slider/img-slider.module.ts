import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ImgSliderRoutingModule } from './img-slider-routing.module';
import {ImgSliderComponent} from "./img-slider.component";


@NgModule({
  declarations: [ImgSliderComponent
  ],
  imports: [
    CommonModule,
    ImgSliderRoutingModule
  ],
  exports:[
    ImgSliderComponent
  ]
})
export class ImgSliderModule { }
