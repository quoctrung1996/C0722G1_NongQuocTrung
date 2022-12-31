import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Product} from '../../model/product';
import {CategoryService} from '../../service/category.service';
import {Observable} from 'rxjs';
import {Category} from '../../model/category';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  categorys:Category[]=[];
  product: Product | undefined;
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
    category:new FormControl()
  });

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute,private router: Router,private categoryService:CategoryService) {
    this.activatedRoute.paramMap.subscribe(data=>{
      const id=data.get("id");
      if (id!=null){
        this.productService.findById(parseInt(id)).subscribe(data=>{
          this.product=data;
          this.productForm.patchValue(this.product);
        },error => {

        },() => {

        });
      }
    })
  }

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(data=>{
      this.categorys=data;
      console.log(this.categorys);
    },error => {
    },() =>{
    });
  }
  submit() {
    const product = this.productForm.value;
    this.productService.updateProduct(product).subscribe(data=>{
      this.router.navigateByUrl("/product/list");
    },error => {

    }, () =>{

    });
    this.productForm.reset();
    alert("Sửa thành công");
  }
}
