import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouteConfigLoadEnd, Router } from '@angular/router';
import { Book } from 'src/app/Entity/Book';
import { AuthorService } from 'src/app/Services/author.service';

@Component({
  selector: 'app-authorbooks',
  templateUrl: './authorbooks.component.html',
  styleUrls: ['./authorbooks.component.css']
})
export class AuthorbooksComponent implements OnInit {

  authorId= this.route.snapshot.params['authorId'];
  books:Book[]=[];

  getAllBooks(){
    console.log(this.authorId)
    const observable = this.authorService.getallAuthorBook(this.authorId);
    observable.subscribe(
      (response)=>{
        console.log(response)
          this.books=response as Book[];
      }
    )
    console.log(this.books);
  }

  blockBook(book,bookId){
    console.log("Block");
    const observable = this.authorService.blockBook(bookId,this.authorId);
    observable.subscribe(
      (response)=>{
        console.log(response)
        if(response){
          book.blocked="no"
        }
        else
        book.blocked="yes"
      }
    )
  }
  unblockBook(book,bookId){
    console.log("Un Block");
    const observable = this.authorService.unblockBook(bookId,this.authorId);
    observable.subscribe(
      (response)=>{
        console.log(response)
        if(response){
          book.blocked="no"
        }
        else
        book.blocked="yes"
      }
    )
  }


  readBook(content){
    console.log("hi");
    this.router.navigate(['/bookcontent',content]);
  }

  createBook(){
    this.router.navigate(['/createbook',this.authorId]);
  }

  constructor(private route: ActivatedRoute,private authorService:AuthorService,private router:Router) { }
 
  ngOnInit(): void {
  }

}
