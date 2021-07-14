import { DataService } from './../../services/current-user/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private dataService: DataService, private router: Router) { }

  ngOnInit(): void {
  }

  onDashboard() {
    this.router.navigate(['bank/home']);
  }

  onAccounts() {
    this.router.navigate(['bank/accounts']);
  }

  onChequeBooks() {
    this.router.navigate(['bank/cheque-books']);
  }

  onTransaction() {
      this.router.navigate(['bank/transactions']);
  }

  onTransfer() {
    this.router.navigate(['bank/transfer']);
  }

  onProfile() {
    this.router.navigate(['bank/profile']);
  }

  onLogout() {
    this.dataService.setIsSafe(false);
    this.dataService.setUser(null);
    this.router.navigate(['login']);
  }
}
