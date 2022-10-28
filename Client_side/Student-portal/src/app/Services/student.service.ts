import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const BASE_URL='http://localhost:5000/students'
const BookAPI_URL='http://localhost:8090/api/v1/digitalbooks/getBook/'
@Injectable({
  providedIn: 'root'
})
export class StudentService {

  saveStudent(
    student: {
      firstName: String,
      lastName: String,
      class: number,
      email: String,
      gender: String
    }
  )
  {
    return this.http.post(BASE_URL,student)
  }

  getStudents()
  {
    return this.http.get(BASE_URL)
  }

  saveIdForBook(id: number){
    return this.http.get(BookAPI_URL+id)
  }

  deleteStudent(student:any){
    return this.http.delete(BASE_URL+"/"+student.id)
  }
  constructor(public http :HttpClient) { }
}
