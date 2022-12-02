import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountDetailsComponent } from './Components/account-details/account-details.component';
import { HomeComponent } from './Components/home/home.component';
import { LoginComponent } from './Components/login/login.component';
import { MainComponent } from './Components/main/main.component';
import { RegisterComponent } from './Components/register/register.component';
import { UpdateAccountComponent } from './Components/update-account/update-account.component';

const routes: Routes = [
  {path:"home",component:HomeComponent},
  {path:"",component:MainComponent},
  {path:"login",component:LoginComponent},
  {path:"register",component:RegisterComponent},
  {path:"account/:username/:response",component:AccountDetailsComponent},
  {path:"updateAccount/:username",component:UpdateAccountComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
