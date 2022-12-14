import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ImgSlideComponent } from './img-slide/img-slide.component';
import {ImgSliderModule} from "./img-slider/img-slider.module";

@NgModule({
  declarations: [
    AppComponent,
    ImgSlideComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ImgSliderModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
