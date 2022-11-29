import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginRequest } from '../Entity/LoginRequest';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient:HttpClient) { }

  loginBank(loginRequest:LoginRequest){
    console.log(loginRequest);

    return this.httpClient.post("http://localhost:8090/customer/login",loginRequest
    ,{responseType:'text' as 'json'});
  }

  registerBank(registerRequest): Observable<any>{
     return this.httpClient.post("http://localhost:8090/customer/register/",registerRequest);
  }
  checkUserName(username){
    return this.httpClient.get("http://localhost:8090/customer/check/"+username)
  }
  getMyLoans(username){
    return this.httpClient.get("http://localhost:8090/getAllLoans/"+username)
  }
  applyLoan(request,username){
    return this.httpClient.post("http://localhost:8090/apply/loan/"+username,request);
  }
  updateAccount(userName,uprequest){
    console.log(uprequest);
    return this.httpClient.put("http://localhost:8090/customer/update/"+userName,uprequest
    ,{responseType:'text' as 'json'});
  }
}
