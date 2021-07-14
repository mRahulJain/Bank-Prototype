import { DataService } from './../../../services/current-user/data.service';
import { UserServiceService } from './../../../services/users/user-service.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginUserId: string = '';
  loginUserPassword: string = '';
  currentLoginCount: number = 3;

  constructor(private router: Router, private userService: UserServiceService, private dataService: DataService) { }

  ngOnInit(): void {
  }

  loginUser() {
    if(this.loginUserId ==='' || this.loginUserPassword === '') {
      alert('Please enter above credentials!');
      return;
    }

    this.userService
    .checkUserByIdAndPassword(this.loginUserId, this.loginUserPassword)
    .subscribe(
      message => {
        if(message.message === 'success') {
          this.userService.getUser(this.loginUserId).subscribe(
            user => {
              this.dataService.setUser(user);
              this.dataService.setIsSafe(true);
              this.router.navigate(['bank/home']);
            }
          )
        } else if(message.message === 'failure') {
          alert(`Your account was blocked in attempt for multiple wrong logins.\nPlease contact your nearest ICIN bank!`);
          return;
        } else if(message.message === 'no-user') {
          alert('Username is not registered yet!');
          return;
        } 
        else {
          if(this.currentLoginCount === 1) {
            this.userService.blockUser(this.loginUserId)
            .subscribe(
              message => alert(message.message),
              error => console.log(error)
            )
            return;
          }
          this.currentLoginCount--;
          alert(`${message.message}\nYou have ${this.currentLoginCount} attempts left!`);
        }
      },
      error => console.log(error),
      () => {
        this.loginUserId = '';
        this.loginUserPassword = '';
      }
    )
  }

}
