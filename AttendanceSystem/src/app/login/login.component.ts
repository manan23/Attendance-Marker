import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { useraccount, UseraccountService } from '../service/useraccount.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: []
})
export class LoginComponent implements OnInit {

  userId = '';
  password = '';
  invalidLogin = false;
  user: useraccount;
  type: string = '';
  constructor(private userService: UseraccountService, private router: Router,
    private loginservice: AuthenticationService) { }
  ngOnInit() {
  }
  private checkLogin() {

    this.userService.checkEmployee(this.userId, this.password)
      .subscribe((data) => {

        console.log("first");
        if (data == 1) {
          this.userService.getEmployee(this.userId).subscribe(
            (data) => {
              if (data.type == "admin") {
                this.router.navigate(['admin'])
                this.userService.setLoggedIn(true);
                return true;
              } else if (data.type == "Student") {
                this.router.navigate(['emp'])
                this.userService.setLoggedIn(true);
                return true;
              } else if (data.type == "Teacher") {
                console.log("third");
                this.router.navigate(['dept'])
                this.userService.setLoggedIn(true);
                return true;
              } else {
                console.log("fourth");
                this.userId = ""
                this.password = ""
                alert("ENTER THE CORRECT USERNAME AND PASSWORD :(");
              }
              console.log("fifth");
            }
          );
        }
      }
      );
    // if (this.loginservice.authenticate(this.username, this.password)
    // ) {
    //   this.router.navigate(['./addemployee'])
    //   this.invalidLogin = false
    // } else
    //   this.invalidLogin = true
  }

  registerForm() {

    this.router.navigate(['registerForm'])
  }
}
