import { UserServiceService } from './../../../services/users/user-service.service';
import { DataService } from './../../../services/current-user/data.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  loginUserId: string = '';
  loginUserPassword: string = '';
  userAccountNumber: string = '';
  userAccountHolderName: string = '';
  passwordLoginIcon: string = 'fas fa-eye-slash';
  passwordLoginType: string = 'password';
  lockIcon: string = 'fas fa-lock';

  constructor(private dataService: DataService, private userService: UserServiceService) { }

  ngOnInit(): void {
    let user = this.dataService.getUser();
    this.loginUserId = user.accountLoginUserId;
    this.loginUserPassword = user.accountLoginPassword;
    this.userAccountNumber = user.accountNumber;
    this.userAccountHolderName = user.accountHolderName;
  }

  onLoginPasswordToggle() {
    if (this.passwordLoginIcon === 'fas fa-eye-slash') {
      this.passwordLoginIcon = 'fas fa-eye';
      this.passwordLoginType = 'text';
      this.lockIcon = 'fas fa-unlock';
    } else {
      this.passwordLoginIcon = 'fas fa-eye-slash';
      this.passwordLoginType = 'password';
      this.lockIcon = 'fas fa-lock';
    }
  }

  updateLoginPassword() {
    if (this.loginUserPassword === '') {
      alert('You need to enter a password!');
      return;
    }
    this.userService
      .updateLoginPassword(this.loginUserPassword, this.userAccountNumber)
      .subscribe(
        message => {
          let user = this.dataService.getUser();
          user.accountLoginPassword = this.loginUserPassword
          this.dataService.setUser(user);
          alert(message.message)
        },
        error => console.log(error)
      )
  }

}
