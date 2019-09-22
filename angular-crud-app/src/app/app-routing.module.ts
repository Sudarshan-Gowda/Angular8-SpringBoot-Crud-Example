import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UpdateUserComponent } from './update-user/update-user.component';


const routes: Routes = [
  {path:'', redirectTo:'users', pathMatch:'full'},
  {path:'users', component: UserListComponent},
  {path:'add', component:CreateUserComponent},
  {path:'details/:userId', component:UserDetailsComponent},
  {path:'modify/:userId', component:UpdateUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
