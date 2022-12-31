import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import {FormControl, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit, OnChanges{
  product:Product|undefined;
  contactForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
    category:new FormControl()
  });

  constructor(private productService: ProductService,private activatedRoute:ActivatedRoute,
              private router:Router) {
    this.activatedRoute.paramMap.subscribe(data=>{
      const id=data.get("id");
      if (id!=null){
        this.productService.findById(parseInt(id)).subscribe(data=>{
          this.product=data;
          this.contactForm.patchValue(this.product);
        })
      }
    },error => {

    },()=>{

    })
  }

  ngOnInit(): void {
  }

  deleteProduct() {
    // @ts-ignore
    this.productService.deleteById(this.product.id);
    document.getElementById('exampleModal')?.click();
    alert('Xoá thành công');
  }

  ngOnChanges(changes: SimpleChanges): void {
    // @ts-ignore
    this.product = this.productService.findById(this.product.id);
    if (this.product == null){
      alert('Sản phẩm không tồn tại');
    }
  }

  submit() {
    const id=this.contactForm.value.id;
    this.productService.deleteProduct(id).subscribe(data=>{
      this.contactForm.reset();
      this.router.navigateByUrl("/product/list")
      alert("Xóa thành công");
    })
  }
}
