import {Component, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-template-form-student',
  templateUrl: './template-form-student.component.html',
  styleUrls: ['./template-form-student.component.css']
})
export class TemplateFormStudentComponent implements OnInit {
  student = {
    studentName: 'Trung',
    address: 'dak lak'
  }
  student1 = {
    studentName: 'Trung',
    address: 'dak lak'
  }

  constructor() {
  }

  ngOnInit(): void {
  }

  onSubmit(createStudentForm: NgForm) {
    this.student1 = createStudentForm.value;
    console.log(this.student1)
  }
}
