import { Component, OnInit } from '@angular/core';
import {Store} from '@ngrx/store/src/store'
import { TodoAdd } from 'src/app/actions/todo.action';
import { Todo } from 'src/app/models/Todo';
@Component({
  selector: 'app-add-todo',
  templateUrl: './add-todo.component.html',
  styleUrls: ['./add-todo.component.css']
})
export class AddTodoComponent implements OnInit {

  constructor(private store: Store<{todos:Todo[]}>) { }

  AddTodoComponent(todo:string){
    const newTodo = new Todo();
    newTodo.title=todo;
    this.store.dispatch(new TodoAdd(newTodo))
  }
  ngOnInit(): void {
  }

}
