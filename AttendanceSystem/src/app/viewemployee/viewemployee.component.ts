import { Component, OnInit } from '@angular/core';
import { useraccount, UseraccountService } from '../service/useraccount.service';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeedetailService, employeedetail } from '../service/employeedetail.service';
import { THROW_IF_NOT_FOUND } from '@angular/core/src/di/injector';

@Component({
  selector: 'app-viewemployee',
  templateUrl: './viewemployee.component.html',
  styleUrls: ['./viewemployee.component.css']
})
export class ViewemployeeComponent implements OnInit {
  message: string
  public employee: employeedetail;
  public user: employeedetail;
  public emp: string;
  public shift: string
  public employeename: employeedetail[];
  public show = false
  constructor(private userService: UseraccountService, private router: Router, private route: ActivatedRoute, private employeeservice: EmployeedetailService) {
    this.userService.currentMessage.subscribe(message => this.message = message)

    this.employeeservice.getEmployee(this.message).subscribe((data) => {
      this.employeeservice.getempbydept(data.standard)
        .subscribe((data) => {
          console.log("EMP:" + JSON.stringify(data))

          this.employeename = data
        });
    }
    );
  }

  ngOnInit() {
  }
  submit() {
    this.userService.setLoggedIn(true);

    this.employeeservice.getEmployee(this.emp)
      .subscribe((data) => {
        console.log(JSON.stringify(data))
        this.employee = data
      }
      );
    this.show = true;
  }
}