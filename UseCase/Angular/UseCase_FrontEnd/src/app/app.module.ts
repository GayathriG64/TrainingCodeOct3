import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './Components/register/register.component';
import { LoginComponent } from './Components/login/login.component';
import { HomeComponent } from './Components/home/home.component';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { ReaderbooksComponent } from './Components/readerbooks/readerbooks.component';
import { AuthorbooksComponent } from './Components/authorbooks/authorbooks.component';
import { BookContentsComponent } from './Components/book-contents/book-contents.component';
import { CreatebookComponent } from './Components/createbook/createbook.component';
import { SubscribedbooksComponent } from './Components/subscribedbooks/subscribedbooks.component';
import { SearchbookComponent } from './Components/searchbook/searchbook.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,
    ReaderbooksComponent,
    AuthorbooksComponent,
    BookContentsComponent,
    CreatebookComponent,
    SubscribedbooksComponent,
    SearchbookComponent
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
