import { Component, OnInit } from '@angular/core';
import Student from 'src/app/Entity/Student';
import { StudentService } from 'src/app/Services/student.service';

@Component({
  selector: 'app-student-reg',
  templateUrl: './student-reg.component.html',
  styleUrls: ['./student-reg.component.css']
})
export class StudentRegComponent implements OnInit {
  
  title="Fill out all the details below"
 /* 
  studentDetails={
    firstName:"",
    lastName:"",
    email:"",
    class:0,
    gender:"Female"
  }
*/

student: Student = new Student();

/*  saveStudentDetails(){
    console.log(this.student)
  }
*/
  save(){
    const observable = this.studentService.saveStudent(this.student);
    observable.subscribe(
      (response: any) => {
        console.log(response);
      }, function(error){
        console.log(error);
        alert("Something wrong.Please try again")
      }
    )
  }

  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
  }

}
