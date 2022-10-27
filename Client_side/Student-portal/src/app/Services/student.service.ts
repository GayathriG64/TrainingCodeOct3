import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const BASE_URL='http://localhost:5000/students'
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
  ){
    return this.http.post(BASE_URL,student)
  }

  constructor(public http :HttpClient) { }
}
