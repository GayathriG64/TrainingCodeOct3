import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from 'src/app/Entity/Book';
import { ReaderService } from 'src/app/Services/reader.service';

@Component({
  selector: 'app-readerbooks',
  templateUrl: './readerbooks.component.html',
  styleUrls: ['./readerbooks.component.css']
})
export class ReaderbooksComponent implements OnInit {
  emailId= this.route.snapshot.params['emailId'];
  readerId=this.route.snapshot.params['readerId'];
  books:Book[]=[];
  
  subscribebook(book,bookId){
  const observable =this.readerService.subscribeBook(this.readerId,bookId)
  observable.subscribe(
    (response)=>{
      console.log(response);
      if(response==0){
        alert("Book is already subscribed by you");
      }
      else{
        alert("Book: "+bookId+" has been subscribed please note the subscription id: "+response+" for future use");
      }
    }
  )
  }
  getAllSubscribedBooks(){
    const observable =this.readerService.getAllSubscribedBooks(this.emailId);
    observable.subscribe(
      (response)=>{
        console.log(response);
        this.books=[];
        this.books= response as Book[];
      }
    )
    }
  unsubscribe(book,bookId){
    const observable =this.readerService.unsubscribeBook(this.readerId,bookId)
    console.log(this.readerId+"-"+bookId)
  observable.subscribe(
    (response)=>{
      console.log(response);
      if(response==1){
        alert("Book: "+bookId+" has been unsubscribed.");
      }
      else if(response==2){
        alert("Book can only be unsubscribed within 24 hours");
      }
      else{
        alert("Please subscribe the book first.");
      }
    }
  )
  }
  readBook(bookid,content){
    const observable=this.readerService.check(this.readerId,bookid);
    observable.subscribe(
      (response)=>{
        console.log(response);
        if(response==1){
          this.router.navigate(['/bookcontent',content]);
          }
        else{
          alert("You can only read your subscribed books.Please subscribe to read this book with id: "+bookid);
        }
      });
  }
  getAllBooks(){
    const observable= this.readerService.getAllBooks(this.emailId);
    observable.subscribe(
      (response)=>{
        console.log(response);
        this.books=[];
        this.books= response as Book[];
      }
    )
  }
  constructor(private route: ActivatedRoute,private readerService:ReaderService,private router:Router) { }

  ngOnInit(): void {
  }

}
