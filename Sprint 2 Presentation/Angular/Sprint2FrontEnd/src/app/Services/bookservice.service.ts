import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const ADDBOOK_URL='http://localhost:8081/add/book'
const READALL_URL='http://localhost:8081/allBooks'
const REMOVE_URL='http://localhost:8081/remove'
@Injectable({
  providedIn: 'root'
})
export class BookserviceService {

  addBook(
    book: {
        bookName: String;
        bookGenre: String;
        bookAuthor: String;
        bookPrice:any;
        borrowedStatus: any;
    }
  )
  {
    return this.http.post(ADDBOOK_URL,book)
  }

  getAllBooks()
  {
    return this.http.get(READALL_URL)
  }

  deleteBookById(book){
    return this.http.delete(REMOVE_URL+"/"+book.bookID)
  }
  constructor(private http: HttpClient) { }
}
