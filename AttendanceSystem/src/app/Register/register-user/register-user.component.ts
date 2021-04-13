import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { employeedetail, EmployeedetailService } from 'src/app/service/employeedetail.service';
import { useraccount, UseraccountService } from 'src/app/service/useraccount.service';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {
  userId = '';
  userPassword = '';
  userName='';
  userPhone=0;
  userEmail='';
  userStandard='';
  invalidLogin = false;
  user: useraccount;
  employee:employeedetail;
  userType='';
  constructor(private userService: UseraccountService,private employeeService: EmployeedetailService,private router: Router) { }

  ngOnInit() {
  }

  registerUser()
  {
    this.user = new useraccount(this.userId,this.userPassword,this.userType);
    this.employee=new employeedetail(this.userId,this.userName,this.userPhone,this.userEmail,this.userType,this.userStandard);

    console.log("User Data"+this.userId+" "+this.userPassword+" "+this.userType);
    console.log("Employee"+this.employee.employeeId+" "+this.employee.name+" "+this.employee.type);

    this.userService.createEmployee(this.user).subscribe(
      (response)=>{
        if(response != null)
        {
             this.employeeService.addemployee(this.employee).subscribe(
            (data)=>{
              if(data != null)
              {
                alert("User is Registered !!");
                this.router.navigate(['']);
              }
              else{
                alert("User is Not Registered !! Please Try again");
              }
            }
          );
        }
        
      }
    )
  }

}
