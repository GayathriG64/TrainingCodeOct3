import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Postauthor } from '../Entity/Postauthor';

const GET_AUTH_BOOKS_URL="http://localhost:9091/api/v1/digitalbooks/userservice/author/getbooks/"

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

  loginAuthor(author: {
    authorName:string 
    authoremailId:string
    authorPassword:string})
  {
// let queryParams = new HttpParams();
// queryParams.append("emailId",author.authoremailId);
// queryParams.append("password",author.authorPassword);
   return this.httpClient.post("http://localhost:9091/api/v1/digitalbooks/userservice/author/login",author
   //{params:queryParams}
   )
  }

  getallAuthorBook(id){
    console.log(id)
    return this.httpClient.get
    ("http://localhost:9091/api/v1/digitalbooks/userservice/author/getbooks/"+id);
  }

  blockBook(bookId,authorId){
    let queryParams = new HttpParams();
    queryParams.append("authorId",authorId);
    queryParams.append("bookId",bookId);
    return this.httpClient.post("http://localhost:9091/api/v1/digitalbooks/userservice/author/block/"+authorId+"/"+bookId,null);
  }
  unblockBook(bookId,authorId){
    return this.httpClient.post("http://localhost:9091/api/v1/digitalbooks/userservice/author/unblock/"+authorId+"/"+bookId,null);
  }

  createbook(book,authorId){
    return this.httpClient.post("http://localhost:9091/api/v1/digitalbooks/userservice/author/createbook/"+authorId,book)
  }
  updateBook(authorId,bookId,book){
    console.log(bookId)
    console.log(authorId)
    console.log(book)
    return this.httpClient.put("http://localhost:9091/api/v1/digitalbooks/userservice/author/edit/"+authorId+"/"+bookId,book)
  }
  searchbook(title,category,price:number,author,publisher){
    let queryparams= new HttpParams();
    queryparams.append("title",title)
    .append("category",category)
    .append("author",author)
    .append("publisher",publisher)
    .append("price",price.toString());
    console.log(queryparams.getAll("author"));
    //console.log(title,category,price,author,publisher)
//return this.httpClient.get('http://localhost:9091/api/v1/digitalbooks/userservice/searchAllBooks',
//{params:queryparams} );

return this.httpClient.get("http://localhost:9091/api/v1/digitalbooks/userservice/searchAllBooks?title="
+title+"&category="+category+"&author="+author+"&publisher="+publisher+"&price="+price.toString())

  }
  
  constructor(private httpClient: HttpClient) { }
}
