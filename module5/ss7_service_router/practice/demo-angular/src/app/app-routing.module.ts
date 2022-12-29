import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DemoComponent} from "./demo/demo.component";

const routes: Routes = [
  {path:"home/:index",component:DemoComponent}

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],//module gốc     forChild:module con
  exports: [RouterModule]
})
export class AppRoutingModule { }
