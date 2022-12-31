import { Injectable } from '@angular/core';
import {Product} from "../model/product";
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  URL_PRODUCT="http://localhost:3000/product";
  products: Product[] = [];
  constructor(private httpClient:HttpClient) { }
  getAll():Observable<Product[]> {
     return this.httpClient.get<Product[]>(this.URL_PRODUCT);
  }
  saveProduct(product: any) {
    return this.httpClient.post(this.URL_PRODUCT,product);
  }

  findById(id:number):Observable<Product>{
    return this.httpClient.get<Product>(this.URL_PRODUCT+"/"+id);
  }

  updateProduct(product:any){
    return this.httpClient.patch(this.URL_PRODUCT+"/"+product.id,product);
  }

  deleteProduct(id:any){
    return this.httpClient.delete(this.URL_PRODUCT+"/"+id,id);
  }

}
