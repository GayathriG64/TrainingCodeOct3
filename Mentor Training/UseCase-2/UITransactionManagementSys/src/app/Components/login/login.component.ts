import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
  
  login(){
    console.log(this.loginRequest)
    this.loginService.loginBank(this.loginRequest).subscribe(
      (response) =>{
        console.log(response);
        this.router.navigate(['account',this.loginRequest.username,response]);
        alert(response);
      } , function(error){
        console.log(error);
        alert("Something wrong.Please try again")
      }
    )
  }

  ngOnInit(): void {
  }

}
