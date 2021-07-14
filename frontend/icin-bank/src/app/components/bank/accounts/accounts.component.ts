import { AccountService } from './../../../services/account/account.service';
import { DataService } from './../../../services/current-user/data.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit {

  accountNumber: string = '';
  accountHolderName: string = '';
  accountCIFNumber: string = '';
  accountBranch: string = '';
  accountBalancePrimary: number = 0;
  accountBalanceSavings: number = 0;

  constructor(private dataService: DataService, private accountService: AccountService) { }

  ngOnInit(): void {
    this.accountService.getAccountByNumber(this.dataService.getUser().accountNumber)
    .subscribe(
      account => {
        this.accountNumber = account.accountNumber;
        this.accountHolderName = account.accountHolderName;
        this.accountCIFNumber = account.accountCIFNumber;
        this.accountBranch = account.accountBranch;
        this.accountBalancePrimary = account.accountBalancePrimary;
        this.accountBalanceSavings = account.accountBalanceSavings;
      },
      error => console.log(error)
    )
  }

}
