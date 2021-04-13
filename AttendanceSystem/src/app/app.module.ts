import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { DepartmentComponent } from './department/department.component';
import { EmployeeComponent } from './employee/employee.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { routes } from './app-routing.module';
import { AuthGuard } from './auth.guard';
import { HeaderempComponent } from './headeremp/headeremp.component'
import { AttendanceempComponent } from './attendanceemp/attendanceemp.component';
import { MonthpipePipe } from './monthpipe.pipe';
import { HeaderdeptComponent } from './headerdept/headerdept.component';
import { DeptattenComponent } from './deptatten/deptatten.component';
import { ViewemployeeComponent } from './viewemployee/viewemployee.component';
import { SplitpipePipe } from './splitpipe.pipe';
import { RegisterUserComponent } from './Register/register-user/register-user.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    LogoutComponent,
    DepartmentComponent,
    EmployeeComponent,
    HeaderempComponent,
    AttendanceempComponent,
    MonthpipePipe,
    HeaderdeptComponent,
    DeptattenComponent,
    ViewemployeeComponent,
    SplitpipePipe,
    RegisterUserComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    FormsModule,    
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
