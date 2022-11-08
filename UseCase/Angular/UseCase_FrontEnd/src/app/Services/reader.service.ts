import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReaderService {
  loginReader(reader:{
    readerName:string,
    emailId:string,
    readerPassword:string
  })
  {
  return this.httpClient.post("http://localhost:9091/api/v1/digitalbooks/reader/login",reader);
  }

  getAllBooks(emailId)
  {
    return this.httpClient.get("http://localhost:9091/api/v1/digitalbooks/readers/Allbooks/"+emailId)
  }

  subscribeBook(readerId,bookId){
    return this.httpClient.post("http://localhost:9091/api/v1/digitalbooks/subscribe/"+readerId+"/"+bookId,null);
  }

  getAllSubscribedBooks(emailId){
    return this.httpClient.get("http://localhost:9091/api/v1/digitalbooks/readers/books/"+emailId);
  }

  unsubscribeBook(readerId,bookId){
    return this.httpClient.post("http://localhost:9091/api/v1/digitalbooks/unsubscribe/"+readerId+"/"+bookId,null);
  }

  constructor(private httpClient:HttpClient) { }
}
