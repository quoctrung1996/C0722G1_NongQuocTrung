import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Todo} from "../model/todo";

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  URL_TODO = "http://localhost:3000/todo";

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Todo[]> {
    return this.httpClient.get<Todo[]>(this.URL_TODO);
  }

  saveTodo(todo: any) {
    return this.httpClient.post(this.URL_TODO, todo);
  }

  deleteId(id: number) {
    return this.httpClient.delete(this.URL_TODO + "/" + id);
  }

}
