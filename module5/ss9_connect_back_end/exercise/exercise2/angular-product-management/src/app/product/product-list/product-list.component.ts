import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  temp:Product|undefined;
  products: Product[] = [];

  constructor(private productService: ProductService) {
    this.productService.getAll().subscribe(data =>{
      console.log(data);
      this.products=data;
    },error => {
    },() =>{
    });
  }

  ngOnInit(): void {
  }

}
