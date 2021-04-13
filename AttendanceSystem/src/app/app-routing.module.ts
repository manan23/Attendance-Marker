import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DepartmentComponent } from './department/department.component';
import { EmployeeComponent } from './employee/employee.component';
import { AuthGuard } from './auth.guard';
import {AttendanceempComponent} from './attendanceemp/attendanceemp.component'
import { DeptattenComponent } from './deptatten/deptatten.component';
import { ViewemployeeComponent } from './viewemployee/viewemployee.component';
import { RegisterUserComponent } from './Register/register-user/register-user.component';
export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'registerForm', component: RegisterUserComponent },
    { path: 'attenemp', component: AttendanceempComponent ,canActivate:[AuthGuard]},
    { path: 'deptatten', component: DeptattenComponent,canActivate:[AuthGuard] },
    { path: 'viewemp', component: ViewemployeeComponent,canActivate:[AuthGuard] },
    { 
      path: 'login', 
      component: LoginComponent,
      canActivate:[AuthGuard]
   },
    {
      path: 'dept',
      component: DepartmentComponent,
      canActivate:[AuthGuard]
      /*children:[
        { path: 'attendance', component: LoginComponent },
        { path: 'leaveaprroval', component: LoginComponent },
        { path: 'overallattendance', component: LoginComponent },
      ]*/
    },
    { 
      path: 'emp',
      component: EmployeeComponent,
      canActivate:[AuthGuard],
      /*children:[
        { path: 'attendance', component: LoginComponent },
        { path: 'overallattendance', component: LoginComponent },
        
      ]*/
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
