import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-font-size-editor',
  templateUrl: './font-size-editor.component.html',
  styleUrls: ['./font-size-editor.component.css']
})
export class FontSizeEditorComponent implements OnInit {
  name:string="Nhập tên";
  title:string="hello";
  srcImage:string="https://www.invert.vn/media/downloads/221203T1328_631.jpg"
  constructor() { }

  ngOnInit(): void {
  }
  updateTitle(){
    this.title="Anh Trung đẹp trai";
    console.log(this.title)
  }


}
