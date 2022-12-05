import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/Entity/Customer';
import { LoginRequest } from 'src/app/Entity/LoginRequest';
import { LoginService } from 'src/app/Service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService:LoginService,private router:Router) { }

  loginRequest:LoginRequest = new LoginRequest() ;
  customer:Customer = new Customer();
  data:any
  login(){
    this.loginService.loginBank(this.loginRequest).subscribe(
      (response) =>{
        //console.log(response);
        this.data= response as Customer;
        this.customer=JSON.parse(this.data)
        if(this.customer.accountId==null){
          alert(this.customer.accType)
        }
        else{
        this.loginService.storeCustomerSession(this.customer);
        alert("Welcome "+this.customer.name+"!!");
        this.router.navigate(['account',this.loginRequest.username,this.customer.name]);
        
        }
      } , function(error){
        console.log(error);
        alert("Something wrong.Please try again")
      }
    )
  }

  ngOnInit(): void {
  }

}
