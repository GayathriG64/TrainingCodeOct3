import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from 'src/app/Entity/Book';
import { AuthorService } from 'src/app/Services/author.service';

@Component({
  selector: 'app-createbook',
  templateUrl: './createbook.component.html',
  styleUrls: ['./createbook.component.css']
})
export class CreatebookComponent implements OnInit {

  authorId = this.route.snapshot.params['authorId'];
  book:Book= new Book();
  savedbook:Book= new Book();
  
  createBook(){
    this.book.AuthorID=this.authorId;
    console.log(this.book);
    if(this.book.active){
      this.book.blocked="no"
    }
    else
    this.book.blocked="yes"
    const observable=this.authorService.createbook(this.book,this.authorId);
    observable.subscribe(
      (response)=>{
        console.log(response)
        this.savedbook =response as Book;
        alert("Book creation done");
      }
    )
    
  }
  goback(){
    this.router.navigate(['/authorbooks',this.authorId]);
  }
 
  constructor(private router:Router,private route: ActivatedRoute,private authorService:AuthorService) { }
  ngOnInit(): void {
  }

}
