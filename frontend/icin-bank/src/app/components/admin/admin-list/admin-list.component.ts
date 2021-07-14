import { AdminDataService } from './../../../services/current-admin/admin-data.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-list',
  templateUrl: './admin-list.component.html',
  styleUrls: ['./admin-list.component.css']
})
export class AdminListComponent implements OnInit {

  constructor(private router: Router, private adminDataService: AdminDataService) { }

  ngOnInit(): void {
  }

  seeBlockedAccounts() {
    this.router.navigate(['admin/blocked-accounts']);
  }

  seeChequeBooks() {
    this.router.navigate(['admin/cheque-requests']);
  }

  seeTransactions() {
    this.router.navigate(['admin/transaction-requests']);
  }

  onLogout() {
    this.adminDataService.setIsSafe(false);
    this.router.navigate(['admin/login']);
  }

}
