import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

  personalDetails={
    FullName:"",
    dob:"",
    email:"",
    mobileNum:0,
    gender:"Male",
    occupation:""
  }

  IdentityDetails={
    idType:"",
    idNum:"",
    issueAuth:"",
    issueDate:"",
    issueState:"",
    expiryDate:""
  }

  displayDetails(){
    console.log(this.personalDetails);
    console.log(this.IdentityDetails);
  }
  constructor() { }

  ngOnInit(): void {
  }

}
