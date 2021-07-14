import { Router } from '@angular/router';
import { UserServiceService } from './../../../services/users/user-service.service';
import { Component, OnInit } from '@angular/core';
import { Users } from 'src/app/model/users';

@Component({
  selector: 'app-admin-block-accounts',
  templateUrl: './admin-block-accounts.component.html',
  styleUrls: ['./admin-block-accounts.component.css']
})
export class AdminBlockAccountsComponent implements OnInit {

  users: Array<Users>;
  toShowUsers: Array<Users>;
  allowBack: boolean = false;
  allowNext: boolean = false;
  current: number;

  constructor(private userService: UserServiceService, private router: Router) { }

  ngOnInit(): void {
    this.userService.getAllBlockedUser()
      .subscribe(
        users => {
          if (users.length > 5) {
            this.allowNext = true;
          }
          this.users = users;
          this.current = 0;
          this.toShowUsers = this.users.slice(this.current, this.current + 5);
        },
        error => console.log(error)
      )
  }

  onPrev() {
    this.allowNext = true;
    this.current = this.current - 5;
    this.toShowUsers = this.users.slice(this.current, this.current + 5);
    if (this.current - 5 < 0) {
      this.allowBack = false;
    } else {
      this.allowBack = true;
    }
  }

  onNext() {
    this.allowBack = true;
    this.current = this.current + 5;
    this.toShowUsers = this.users.slice(this.current, this.current + 5);
    if (this.current + 5 >= this.users.length) {
      this.allowNext = false;
    } else {
      this.allowNext = true;
    }
  }

  unblock(loginUserId: string) {
    this.userService.unblockUser(loginUserId)
      .subscribe(
        message => {
          alert(message.message)
          this.userService.getAllBlockedUser()
            .subscribe(
              users => {
                if (users.length > 5) {
                  this.allowNext = true;
                }
                this.users = users;
                this.toShowUsers = this.users.slice(this.current, this.current + 5);
              },
              error => console.log(error)
            )
        },
        error => console.log(error)
      )
  }

  onBack() {
    this.router.navigate(['admin/options']);
  }

  onRefresh() {
    this.userService.getAllBlockedUser()
      .subscribe(
        users => {
          if (users.length > 5) {
            this.allowNext = true;
          }
          this.users = users;
          this.toShowUsers = this.users.slice(this.current, this.current + 5);
        },
        error => console.log(error)
      )
  }

}
