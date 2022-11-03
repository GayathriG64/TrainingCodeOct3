import { Component, OnInit } from '@angular/core';
import Book from 'src/app/Entity/Book';
import BookGet from 'src/app/Entity/Bookget';
import { BookserviceService } from 'src/app/Services/bookservice.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  book :BookGet = new BookGet();
  availablity:any;
  addBook(){
    if(this.availablity=="Yes"){
      this.book.borrowedStatus = true;
    }
    else{
      this.book.borrowedStatus = false;
    }
    const observable = this.bookservice.addBook(this.book);
    observable.subscribe(
      (response: any) => {
        console.log(response);
      }, function(error){
        console.log(error);
        alert("Something wrong.Please try again")
      }
    )
  }
  constructor(private bookservice:BookserviceService) { }

  ngOnInit(): void {
  }

}
