import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { employeedetail, EmployeedetailService } from '../service/employeedetail.service';
import { UseraccountService } from '../service/useraccount.service';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styles: []
})
export class DepartmentComponent implements OnInit {
  public employee:employeedetail;
  name="asd"
  message:string;
  constructor(private userService: UseraccountService,private router: Router,private route:ActivatedRoute,private employeeservice : EmployeedetailService,
  ) {
    this.def();
   }

  ngOnInit() {
  }

  def(){
    this.userService.currentMessage.subscribe(message => this.message = message)
    this.employeeservice.getEmployee(this.message)
    .subscribe( (data) => {
      console.log(JSON.stringify(data)) 
      this.employee = data;
  }
  
  
    );
  }
}
