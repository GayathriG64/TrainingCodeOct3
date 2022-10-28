import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookLibraryComponent } from './Components/book-library/book-library.component';
import { HomeComponent } from './Components/home/home.component';
import { RegisteredStudentsComponent } from './Components/registered-students/registered-students.component';
import { StudentRegComponent } from './Components/student-reg/student-reg.component';

const routes: Routes = [{path:"",component:HomeComponent},
{path:"register", component:StudentRegComponent},
{path:"registeredStudents",component:RegisteredStudentsComponent},
{path:"library", component:BookLibraryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
