import { Component, OnInit } from '@angular/core';
import Student from 'src/app/Entity/Student';
import { StudentService } from 'src/app/Services/student.service';

@Component({
  selector: 'app-registered-students',
  templateUrl: './registered-students.component.html',
  styleUrls: ['./registered-students.component.css']
})
export class RegisteredStudentsComponent implements OnInit {
  deleteStudent(student,index){
    const observables= this.studentService.deleteStudent(student);
    observables.subscribe((response:any)=>{
      console.log(response);
      this.students.splice(index,1);
    })
  }

  sort(){
    this.students.sort(function(student1,student2){
      return student1.class-student2.class
    })
  }
  students:Student[]=[];

  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    const promise= this.studentService.getStudents();
    promise.subscribe(
      (response)=> {
        console.log(response);
        this.students = response as Student[];
        }
     )
  }

}
