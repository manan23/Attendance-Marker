import { Component, OnInit } from '@angular/core';
import { UseraccountService } from '../service/useraccount.service';
import { AttendancedetailService, attendace } from '../service/attendancedetail.service';
import { employeedetail, EmployeedetailService } from '../service/employeedetail.service';
import { formatDate } from '@angular/common';
import { Router } from '@angular/router';
@Component({
  selector: 'app-deptatten',
  templateUrl: './deptatten.component.html',
  styleUrls: ['./deptatten.component.css']
})
export class DeptattenComponent implements OnInit {
  message: string;
  standard: string;
  showActions: boolean = false;
  public studentList: employeedetail[];
  public attendanceList: attendace[];
  todayDate: Date = new Date();
  count: number
  public atten: attendace
  public at: object[]

  constructor(private attendance: AttendancedetailService, private userService: UseraccountService, private employeeservice: EmployeedetailService, private router: Router) {
    this.userService.currentMessage.subscribe(message => this.message = message)

    this.employeeservice.getEmployee(this.message).subscribe((data) => {
      this.standard = data.standard;
      this.employeeservice.getempbydept(data.standard)
        .subscribe((data) => {
          this.studentList = data;

          for (let student of this.studentList) {
            this.attendance.addattenIfNot(new attendace(student.employeeId, student.name, "", "", date, student.standard, "")).subscribe(
              (result) => {
                console.log(result);
              });
          }
        });
      const date = formatDate(this.todayDate, 'dd-MMM-yyyy', 'en_IN');








      this.getAttendance(this.standard, date.toString());


    }
    );
  }

  ngOnInit() {
  }
  submit(student: employeedetail, attendanceValue: string) {

    const date = formatDate(this.todayDate, 'dd-MMM-yyyy', 'en_IN');
    this.atten = new attendace(student.employeeId, student.name, (this.todayDate.getMonth() + 1).toString(), this.todayDate.getFullYear().toString(), date.toString(), student.standard, attendanceValue)
    console.log(this.atten.available);

    this.attendance.addatten(this.atten).subscribe((data) => {
      console.log(data);

      // this.at = data as Object[];
      //this.showActions=true;
    }
    );

  }
  request() {
    this.router.navigate(['/dept']);
  }
  getAttendance(standard: string, date: string) {
    this.attendance.getattendanceByDateAndStandard(date, standard).subscribe(
      (result) => {
        this.attendanceList = result;
        console.log("Result: ",result +" "+this.attendanceList);
      }
    );
  }
}


