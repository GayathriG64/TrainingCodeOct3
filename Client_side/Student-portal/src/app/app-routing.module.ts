import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Components/home/home.component';
import { RegisteredStudentsComponent } from './Components/registered-students/registered-students.component';
import { StudentRegComponent } from './Components/student-reg/student-reg.component';

const routes: Routes = [{path:"",component:HomeComponent},
{path:"register", component:StudentRegComponent},
{path:"registeredStudents",component:RegisteredStudentsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
