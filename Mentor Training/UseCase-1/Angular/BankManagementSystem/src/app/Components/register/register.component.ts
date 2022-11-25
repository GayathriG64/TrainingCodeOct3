import { Component, OnInit } from '@angular/core';
import { RegisterRequest } from 'src/app/Entity/RegisterRequest';
import { LoginService } from 'src/app/Service/login.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private loginService: LoginService) { }
  public registerRequest: RegisterRequest = new RegisterRequest();
  result: Boolean = true;
  register() {
    this.loginService.registerBank(this.registerRequest).subscribe(
      (response) => {
        console.log(response);
        if (response == 0) {
          alert("Please enter unique username and email")
        }
        else {
          alert("Successfully registered and your accountID is : " + response);
        }
      }, function (error) {
        console.log(error);
        alert("Something wrong.Please try again")
      }
    )
  }

public checkUserName() {
  const observable = this.loginService.checkUserName(this.registerRequest.username);
  observable.subscribe(
    (response) => {
      this.result = response as Boolean;
      console.log(response);
      if (!response) {
        alert("Username is already taken.")
      }
    }
  )
}
ngOnInit(): void {
}

}
