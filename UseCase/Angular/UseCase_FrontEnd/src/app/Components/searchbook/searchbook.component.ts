import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/Entity/Book';
import { AuthorService } from 'src/app/Services/author.service';

@Component({
  selector: 'app-searchbook',
  templateUrl: './searchbook.component.html',
  styleUrls: ['./searchbook.component.css']
})
export class SearchbookComponent implements OnInit {

  books:Book[]= [];
  book:Book=new Book();

  searchbook(){
    console.log(this.book);
    const observable= this.authorService.searchbook(this.book.title,this.book.category,this.book.price,this.book.author,this.book.publisher)
    observable.subscribe(
      (response)=>{
     // console.log(response);
      this.books=response as Book[];
      }
    )
  }
  constructor(private authorService:AuthorService) { }

  ngOnInit(): void {
  }

}
