import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBookComponent } from './Components/add-book/add-book.component';
import { GetBooksDeleteComponent } from './Components/get-books-delete/get-books-delete.component';
import { HomeComponent } from './Components/home/home.component';

const routes: Routes = [
  {path:"home",component:HomeComponent},
  {path:"addbook",component:AddBookComponent},
  {path:"getbooks",component:GetBooksDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
