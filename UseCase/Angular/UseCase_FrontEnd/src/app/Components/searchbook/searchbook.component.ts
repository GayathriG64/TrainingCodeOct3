import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/Entity/Book';

@Component({
  selector: 'app-searchbook',
  templateUrl: './searchbook.component.html',
  styleUrls: ['./searchbook.component.css']
})
export class SearchbookComponent implements OnInit {

  book:Book= new Book();

  constructor() { }

  ngOnInit(): void {
  }

}
