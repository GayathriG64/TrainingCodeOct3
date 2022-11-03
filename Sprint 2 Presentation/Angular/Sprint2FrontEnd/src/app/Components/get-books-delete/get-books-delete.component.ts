import { Component, OnInit } from '@angular/core';
import Book from 'src/app/Entity/Book';
import { BookserviceService } from 'src/app/Services/bookservice.service';

@Component({
  selector: 'app-get-books-delete',
  templateUrl: './get-books-delete.component.html',
  styleUrls: ['./get-books-delete.component.css']
})
export class GetBooksDeleteComponent implements OnInit {

  books: Book[]=[];
  getAllBooks(){
    const promise=this.bookService.getAllBooks();
    promise.subscribe(
      (response)=>{
          this.books=response as Book[];
      }
    )
  }

  deleteBook(deleteBook,index){
      const observables=this.bookService.deleteBookById(deleteBook);
      observables.subscribe(
        (response)=>{
          //console.log(response);
          this.books.splice(index,1);
        }
      )
  }
  constructor(private bookService:BookserviceService) { }

  ngOnInit(): void {
  }

}
