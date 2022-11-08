import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthorbooksComponent } from './Components/authorbooks/authorbooks.component';
import { BookContentsComponent } from './Components/book-contents/book-contents.component';
import { CreatebookComponent } from './Components/createbook/createbook.component';
import { LoginComponent } from './Components/login/login.component';
import { ReaderbooksComponent } from './Components/readerbooks/readerbooks.component';
import { RegisterComponent } from './Components/register/register.component';

const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"register",component:RegisterComponent},
  {path:"authorbooks/:authorId",component:AuthorbooksComponent},
  {path:"readerbooks/:readerId/:emailId",component:ReaderbooksComponent},
  {path:"bookcontent/:content",component:BookContentsComponent},
  {path:"createbook/:authorId",component:CreatebookComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
