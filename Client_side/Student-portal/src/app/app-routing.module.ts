import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './Components/about/about.component';
import { BookLibraryComponent } from './Components/book-library/book-library.component';
import { ContactUsComponent } from './Components/contact-us/contact-us.component';
import { HomeComponent } from './Components/home/home.component';
import { PipeDemoComponent } from './Components/pipe-demo/pipe-demo.component';
import { RegisteredStudentsComponent } from './Components/registered-students/registered-students.component';
import { StudentRegComponent } from './Components/student-reg/student-reg.component';

const routes: Routes = [{path:"",component:HomeComponent},
{path:"register", component:StudentRegComponent},
{path:"registeredStudents",component:RegisteredStudentsComponent},
{path:"library", component:BookLibraryComponent},
{path:"about",component:AboutComponent},
{path:"contactUs",component: ContactUsComponent},
{path:"pipe",component:PipeDemoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
