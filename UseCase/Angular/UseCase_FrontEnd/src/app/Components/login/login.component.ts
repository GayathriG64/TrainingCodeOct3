import { Component, OnInit } from '@angular/core';
import { Author } from 'src/app/Entity/Author';
import { Postauthor } from 'src/app/Entity/Postauthor';
import { Postreader } from 'src/app/Entity/Postreader';
import { Reader } from 'src/app/Entity/Reader';
import { AuthorService } from 'src/app/Services/author.service';
import { ReaderService } from 'src/app/Services/reader.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  role: string;
  userName: string;
  emailId: string;
  password: string;
  author: Postauthor= new Postauthor();
  reader: Postreader= new Postreader();
  login(){
    if (this.role == "author"){
      this.author.authorName="";
      this.author.authoremailId=this.emailId;
      this.author.authorPassword=this.password;
      console.log(this.author);
      const observable= this.authorService.loginAuthor(this.author);
      observable.subscribe(
        (response: any) => {
          console.log(response);
          if(response!=0){
            alert("Login success !")
            this.router.navigate(['/authorbooks',response]);
          }
          else{
            alert("Please give valid credentials")
          }
        }, function(error){
          console.log(error);
          alert("Something wrong.Please try again")
        }
      )
    }
    else{
      this.reader.readerName="";
      this.reader.emailId=this.emailId;
      this.reader.readerPassword=this.password;
      console.log(this.reader);
      const observable= this.readerService.loginReader(this.reader);
      observable.subscribe(
        (response: any) => {
          console.log(response);
          if(response!=0){
            alert("Login success !")
            this.router.navigate(['/readerbooks',response,this.emailId]);
          }
          else{
            alert("Please give valid credentials")
          }
        }, function(error){
          console.log(error);
          alert("Something wrong.Please try again")
        }
      )
    }
  }
  constructor(private authorService: AuthorService,private readerService: ReaderService,
    private router:Router) { }

  ngOnInit(): void {
  }

}
