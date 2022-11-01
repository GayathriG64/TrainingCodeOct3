import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/models/Todo';
import { select, Store } from '@ngrx/store/src'

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css'],
})

export class TodoComponent implements OnInit {
  todos: Todo[];
  constructor (private store: Store<{ todos: Todo[] }>) {
    store.pipe(select('todos')).subscribe((values) => {
      this.todos = values;
      console.log(values);
    });
  }

  ngOnInit(): void {
  }

}
