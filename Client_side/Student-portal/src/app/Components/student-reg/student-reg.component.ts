import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student-reg',
  templateUrl: './student-reg.component.html',
  styleUrls: ['./student-reg.component.css']
})
export class StudentRegComponent implements OnInit {
  
  title="Fill out all the details below"
  studentDetails={
    FullName:"",
    email:"",
    class:0,
    gender:"FEMALE"
  }

  saveStudentDetails(){
    console.log(this.studentDetails)
  }
  constructor() { }

  ngOnInit(): void {
  }

}
