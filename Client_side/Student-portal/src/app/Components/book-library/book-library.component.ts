import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import Book from 'src/app/Entity/Book';
import Student from 'src/app/Entity/Student';
import { StudentService } from 'src/app/Services/student.service';

@Component({
  selector: 'app-book-library',
  templateUrl: './book-library.component.html',
  styleUrls: ['./book-library.component.css']
})
export class BookLibraryComponent implements OnInit {
   book = new Book;
  bookid=1;

  submitid(): void{
     const promise= this.studentService.saveIdForBook(this.bookid);
     promise.subscribe(
       (response)=> {
         console.log(this.bookid);
         this.book = response as Book;
         console.log(this.book);
         }
      )
     }

  constructor(private studentService: StudentService, private httpClient: HttpClient) { }

  ngOnInit(): void {
   
  }

}
