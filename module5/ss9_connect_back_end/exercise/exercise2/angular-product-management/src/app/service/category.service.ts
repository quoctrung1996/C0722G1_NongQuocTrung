import { Injectable } from '@angular/core';
import {Category} from '../model/category';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  URL_CATEGORY="http://localhost:3000/category";

  categories: Category[] = [];

  constructor(private httpClient:HttpClient) {
  }

  getAll():Observable<Category[]> {
    return this.httpClient.get<Category[]>(this.URL_CATEGORY);
  }

  saveCategory(category:any) {
    this.categories.push(category);
  }

  findById(id: number):Category {
    let temp = this.categories.filter(category => category.id === id);
    return temp[0];
  }

  updateCategory(id: number, category: Category) {
    for (let i = 0; i < this.categories.length; i++) {
      if (this.categories[i].id === id) {
        this.categories[i] = category;
      }
    }
  }

  deleteCategory(id: number|undefined) {
    if (id != undefined) {
      let category = this.findById(id);
      if (category != null) {
        let length = this.categories.length
        for (let i = 0; i < length; i++) {
          if (category.id == this.categories[i].id) {
            this.categories.splice(i, 1);
            break;
          }
        }
      }
    }
  }
}
