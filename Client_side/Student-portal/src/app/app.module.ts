import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Components/home/home.component';
import { StudentRegComponent } from './Components/student-reg/student-reg.component';
import { UserFormComponent } from './Components/user-form/user-form.component';
import { NavbarComponent } from './Components/navbar/navbar.component';
import {HttpClientModule} from '@angular/common/http';
import { RegisteredStudentsComponent } from './Components/registered-students/registered-students.component';
import { BookLibraryComponent } from './Components/book-library/book-library.component';
import { AboutComponent } from './Components/about/about.component';
import { ContactUsComponent } from './Components/contact-us/contact-us.component';
import { PipeDemoComponent } from './Components/pipe-demo/pipe-demo.component';
import { EllipsisPipe } from './Pipes/ellipsis.pipe'

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    StudentRegComponent,
    UserFormComponent,
    NavbarComponent,
    RegisteredStudentsComponent,
    BookLibraryComponent,
    AboutComponent,
    ContactUsComponent,
    PipeDemoComponent,
    EllipsisPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
