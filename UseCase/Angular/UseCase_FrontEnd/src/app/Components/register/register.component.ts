import { Component, OnInit } from '@angular/core';
import { Author } from 'src/app/Entity/Author';
import { Postauthor } from 'src/app/Entity/Postauthor';
import { Postreader } from 'src/app/Entity/Postreader';
import { AuthorService } from 'src/app/Services/author.service';
import { ReaderService } from 'src/app/Services/reader.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  role: string;
  userName: string;
  emailId: string;
  password: string;
  author: Postauthor= new Postauthor();
  reader: Postreader= new Postreader();
  register() {
    if (this.role == "author") {
      this.author.authorName=this.userName;
      this.author.authoremailId=this.emailId;
      this.author.authorPassword=this.password;
      console.log(this.author);
      const observable= this.authorService.registerAuthor(this.author);
      observable.subscribe(
        (response: any) => {
          console.log(response);
          alert("Successfully registered as Author with id : "+response)
        }, function(error){
          console.log(error);
          alert("Something wrong.Please try again")
        }
      )
    }

    if (this.role == "reader") {
      this.reader.readerName=this.userName;
      this.reader.emailId=this.emailId;
      this.reader.readerPassword=this.password;
      console.log(this.reader);
      const observable= this.readerService.registerReader(this.reader);
      observable.subscribe(
        (response: any) => {
          console.log(response);
          if(response==0){
            alert("You are an existing reader. Please login.")
          }
          else{
          alert("Successfully registered reader with ID: "+response)
          }
        }, function(error){
          console.log(error);
          alert("Something wrong.Please try again")
        }
      )
    }
  }
  
  constructor(private authorService: AuthorService,private readerService: ReaderService) { }

  ngOnInit(): void {
  }

}
