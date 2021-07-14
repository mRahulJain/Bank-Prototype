import { AdminDataService } from './../../../services/current-admin/admin-data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  adminUsername: string = '';
  adminPassword: string = '';

  constructor(private router: Router, private adminDataService: AdminDataService) { }

  ngOnInit(): void {
  }

  loginAdmin() {
    if(this.adminUsername === 'admin' && this.adminPassword === 'icinbank') {
      this.adminDataService.setIsSafe(true);
      this.router.navigate(['admin/options']);
      return;
    }
    alert('Incorrect Credentials!');
  }

}
