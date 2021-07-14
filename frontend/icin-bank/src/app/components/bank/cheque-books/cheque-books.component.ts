import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UserServiceService } from './../../../services/users/user-service.service';
import { DataService } from './../../../services/current-user/data.service';
import { Component, OnInit } from '@angular/core';
import { ChequeBooks } from 'src/app/model/cheque-books';

@Component({
  selector: 'app-cheque-books',
  templateUrl: './cheque-books.component.html',
  styleUrls: ['./cheque-books.component.css']
})
export class ChequeBooksComponent implements OnInit {

  chequeBooks: Array<ChequeBooks>;
  toShowChequeBooks: Array<ChequeBooks>;
  allowBack: boolean = false;
  allowNext: boolean = false;
  current: number;

  constructor(
    private dataService: DataService,
    private userService: UserServiceService,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.userService.getChequeBooks(this.dataService.getUser().accountNumber)
      .subscribe(
        chequeBooks => {
          if (chequeBooks.length > 5) {
            this.allowNext = true;
          }
          this.chequeBooks = chequeBooks;
          this.current = 0;
          this.toShowChequeBooks = this.chequeBooks.slice(this.current, this.current + 5);
        },
        error => console.log(error)
      )
  }

  onPrev() {
    this.allowNext = true;
    this.current = this.current - 5;
    this.toShowChequeBooks = this.chequeBooks.slice(this.current, this.current + 5);
    if (this.current - 5 < 0) {
      this.allowBack = false;
    } else {
      this.allowBack = true;
    }
  }

  onNext() {
    this.allowBack = true;
    this.current = this.current + 5;
    this.toShowChequeBooks = this.chequeBooks.slice(this.current, this.current + 5);
    if (this.current + 5 >= this.chequeBooks.length) {
      this.allowNext = false;
    } else {
      this.allowNext = true;
    }
  }

  generateDate(date: Date): string {
    let myDate = `${date}`.slice(0, 10);
    return myDate;
  }

  generateStatus(code: number): string {
    if (code === 1) {
      return 'Success';
    }
    return 'Pending';
  }

  requestChequeBookPrimary() {
    this.userService.requestChequeBook(this.dataService.getUser().accountNumber, 'Primary')
      .subscribe(
        message => {
          alert(message.message);
          this.userService.getChequeBooks(this.dataService.getUser().accountNumber)
            .subscribe(
              chequeBooks => {
                if (chequeBooks.length > 5) {
                  this.allowNext = true;
                }
                this.chequeBooks = chequeBooks;
                this.toShowChequeBooks = this.chequeBooks.slice(this.current, this.current + 5);
              },
              error => console.log(error)
            )
        },
        error => console.log(error)
      )
  }
  requestChequeBookSavings() {
    this.userService.requestChequeBook(this.dataService.getUser().accountNumber, 'Savings')
      .subscribe(
        message => {
          alert(message.message);
          this.userService.getChequeBooks(this.dataService.getUser().accountNumber)
            .subscribe(
              chequeBooks => {
                if (chequeBooks.length > 5) {
                  this.allowNext = true;
                }
                this.chequeBooks = chequeBooks;
                this.toShowChequeBooks = this.chequeBooks.slice(this.current, this.current + 5);
              },
              error => console.log(error)
            )
        },
        error => console.log(error)
      )
  }

  open(content) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((result) => {
      console.log(result);
      if (result === 'Primary') {
        this.requestChequeBookPrimary();
      } else {
        this.requestChequeBookSavings();
      }
    }, (reason) => {
    });
  }

}
