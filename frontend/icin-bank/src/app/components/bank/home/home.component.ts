import { DataService } from './../../../services/current-user/data.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  userName: string = '';

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.userName = this.dataService.getUser().accountHolderName;
  }

}
