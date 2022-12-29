import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit,OnChanges{
  @Input() product: Product | null | undefined;

  constructor(private productService: ProductService) { }

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
    this.product=this.productService.findById(this.product.id);
    if(this.product==null){
      alert("Sản phẩm không tồn tại");
    }
  }
}
