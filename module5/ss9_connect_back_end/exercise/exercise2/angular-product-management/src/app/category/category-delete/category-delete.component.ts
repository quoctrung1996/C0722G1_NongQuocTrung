import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {CategoryService} from '../../service/category.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Category} from '../../model/category';

@Component({
  selector: 'app-category-delete',
  templateUrl: './category-delete.component.html',
  styleUrls: ['./category-delete.component.css']
})
export class CategoryDeleteComponent implements OnInit {
  category:Category={};

  categoryForm: FormGroup =new FormGroup({
    id:new FormControl(),
    name:new FormControl()
  });

  constructor(private categoryService: CategoryService,
              private router: Router,
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


  deleteCategory() {
    const id=this.categoryForm.controls.id.value;
    this.categoryService.deleteCategory(id);
    this.router.navigate(['/category/list']);
  }
}
