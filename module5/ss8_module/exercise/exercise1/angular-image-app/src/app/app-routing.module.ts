import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ImgSlideComponent} from "./img-slide/img-slide.component";

const routes: Routes = [
  {path:'',component:ImgSlideComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
