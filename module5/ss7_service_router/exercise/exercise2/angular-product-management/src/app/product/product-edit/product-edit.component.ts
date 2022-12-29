import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute} from "@angular/router";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  product: Product | null | undefined;
  products:Product[]|undefined;
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
  });

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    let index = this.activatedRoute.snapshot.params['id'];
    this.product = this.productService.findById(parseInt(index));
    // @ts-ignore
    this.productForm.patchValue(this.product) //map dữ liệu qua form
  }

  submit() {
    this.products=this.productService.getAll();
    const product = this.productForm.value;
    // @ts-ignore
    this.productService.editProduct(product);
    this.productForm.reset();
    alert("Sửa thành công");
  }
}
