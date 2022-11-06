import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Postauthor } from '../Entity/Postauthor';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  registerAuthor(author: {
    authorName:string 
    authoremailId:string
    authorPassword:string
  })
  {
     return this.httpClient.post("http://localhost:9091/api/v1/digitalbooks/userservice/author/signin",author);
  }

  constructor(private httpClient: HttpClient) { }
}
