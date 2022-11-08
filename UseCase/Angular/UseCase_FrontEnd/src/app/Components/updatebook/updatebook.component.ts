import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from 'src/app/Entity/Book';
import { AuthorService } from 'src/app/Services/author.service';

@Component({
  selector: 'app-updatebook',
  templateUrl: './updatebook.component.html',
  styleUrls: ['./updatebook.component.css']
})
export class UpdatebookComponent implements OnInit {

  authorId = this.route.snapshot.params['authorId'];
  bookId= this.route.snapshot.params['bookId'];
  book:Book= new Book();
  savedbook:Book= new Book();
  updateBook(){
    const observable =this.authorService.updateBook(this.authorId,this.bookId,this.book);
    console.log(this.book)
    observable.subscribe(
      (response)=>{
        console.log(response)
        if(response){
          alert("Book updated!")
        }
        else
        alert("Book not updated!")
      }
    )
  }

  goback(){
    this.router.navigate(['/authorbooks',this.authorId]);
  }
  constructor(private router:Router,private route:ActivatedRoute,private authorService:AuthorService) { }

  ngOnInit(): void {
  }

}
