import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {CategoryService} from '../../service/category.service';
import {Category} from '../../model/category';

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent implements OnInit {
  category:Category={};

  categoryForm: FormGroup =new FormGroup({
      id:new FormControl(),
      name:new FormControl()
  });



  constructor(private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe(data => {
      const id = data.get('id');
      if (id!=null){
        this.category = this.categoryService.findById(parseInt(id));
      }
      this.categoryForm.patchValue(this.category);
    });
  }

  ngOnInit() {
  }

  updateCategory() {
    const category = this.categoryForm.value;
    this.categoryService.updateCategory(this.categoryForm.controls.id.value, category);
    alert('Cập nhật thành công');
  }
}
