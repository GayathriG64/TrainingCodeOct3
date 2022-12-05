import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginRequest } from '../Entity/LoginRequest';
import { Transaction } from '../Entity/Transaction';

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
  getCustomer(username){
    return this.httpClient.get("http://localhost:8090/customer/getCustomer/"+username)
  }
  getAllTransactions(username){
    return this.httpClient.get<Transaction[]>("http://localhost:8090/customer/getAllTransactions/"+username);
  }
  saveTransaction(request){
    return this.httpClient.post("http://localhost:8090/customer/sendMoney",request);
  }

  storeCustomerSession(customer:any){
    localStorage.setItem("customer",JSON.stringify(customer))
  }
  getCustomerSession(){
    return localStorage.getItem("customer")
  }
  clearSession(){
    localStorage.clear();
  }
}
