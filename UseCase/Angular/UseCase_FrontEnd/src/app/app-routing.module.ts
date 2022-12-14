import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthorbooksComponent } from './Components/authorbooks/authorbooks.component';
import { BookContentsComponent } from './Components/book-contents/book-contents.component';
import { CreatebookComponent } from './Components/createbook/createbook.component';
import { LoginComponent } from './Components/login/login.component';
import { MainComponent } from './Components/main/main.component';
import { ReaderbooksComponent } from './Components/readerbooks/readerbooks.component';
import { RegisterComponent } from './Components/register/register.component';
import { SearchbookComponent } from './Components/searchbook/searchbook.component';
import { UpdatebookComponent } from './Components/updatebook/updatebook.component';

const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"register",component:RegisterComponent},
  {path:"authorbooks/:authorId",component:AuthorbooksComponent},
  {path:"readerbooks/:readerId/:emailId",component:ReaderbooksComponent},
  {path:"bookcontent/:content",component:BookContentsComponent},
  {path:"createbook/:authorId",component:CreatebookComponent},
  {path:"searchbook",component:SearchbookComponent},
  {path:"main",component:MainComponent},
  {path:"updatebook/:authorId/:bookId",component:UpdatebookComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
