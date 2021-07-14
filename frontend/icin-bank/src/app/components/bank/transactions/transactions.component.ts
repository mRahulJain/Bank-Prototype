import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { AccountService } from './../../../services/account/account.service';
import { DataService } from './../../../services/current-user/data.service';
import { TransactionsService } from 'src/app/services/transactions/transactions.service';
import { Component, OnInit } from '@angular/core';
import { Transactions } from 'src/app/model/transactions';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {

  transactions: Array<Transactions>
  toShowTransactions: Array<Transactions>
  allowBack: boolean = false;
  allowNext: boolean = false;
  current: number;
  amountColor: string = '';
  startDate: Date = null;
  endDate: Date = null;

  constructor(
    private dataService: DataService,
    private transactionsService: TransactionsService,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.transactionsService.getTransactions(this.dataService.getUser().accountNumber)
      .subscribe(
        transactions => {
          if (transactions.length > 5) {
            this.allowNext = true;
          }
          this.transactions = transactions;
          this.current = 0;
          this.toShowTransactions = this.transactions.slice(this.current, this.current + 5);
        },
        error => console.log(error)
      )
  }

  onPrev() {
    this.allowNext = true;
    this.current = this.current - 5;
    this.toShowTransactions = this.transactions.slice(this.current, this.current + 5);
    if (this.current - 5 < 0) {
      this.allowBack = false;
    } else {
      this.allowBack = true;
    }
  }

  onNext() {
    this.allowBack = true;
    this.current = this.current + 5;
    this.toShowTransactions = this.transactions.slice(this.current, this.current + 5);
    if (this.current + 5 >= this.transactions.length) {
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

  checkSelf(accountNumber: string): string {
    if (this.dataService.getUser().accountNumber === accountNumber) {
      return 'Self'
    }
    return accountNumber;
  }

  generateRemarks(
    fromAN: string,
    toAN: string,
    from: string,
    to: string,
    fromAT: string,
    toAT: string,
    message: string
  ): string {
    let type = this.generateType(fromAN, toAN);
    if (type === 'Debit') {
      this.amountColor = 'text-danger';
      return `from:${fromAT}/to:${to}/mess:${message}`;
    } else if (type === 'Credit') {
      this.amountColor = 'text-success';
      return `from:${from}/to:${toAT}/mess:${message}`;
    }
    this.amountColor = '';
    return `from:${fromAT}/to:${toAT}/self-transfer/mess:${message}`;
  }

  generateTransferAmount(amount: number, from: string, to: string): string {
    let type = this.generateType(from, to);
    if (type === 'Debit') {
      return `${amount} (Dr)`;
    } else if (type === 'Credit') {
      return `${amount} (Cr)`;
    }
    return `${amount}`;
  }

  generateType(from: string, to: string): string {
    let curr_acc = this.dataService.getUser().accountNumber;
    if (to === curr_acc && from === curr_acc) {
      return '-';
    }
    if (to === curr_acc) {
      return 'Credit';
    }
    return 'Debit';
  }

  open(content) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((result) => {
      console.log(result);
      if (result === 'Filter') {
        if (!(this.startDate === null || this.endDate === null)) {
          this.transactionsService
            .getFilteredTransactions(
              this.dataService.getUser().accountNumber,
              this.startDate,
              this.endDate
            ).subscribe(
              transactions => {
                if (transactions.length > 5) {
                  this.allowNext = true;
                }
                this.transactions = transactions;
                this.current = 0;
                this.toShowTransactions = this.transactions.slice(this.current, this.current + 5);
              },
              error => console.log(error)
            )
        }
      } else {
        this.startDate = null;
        this.endDate = null;
        this.transactionsService.getTransactions(this.dataService.getUser().accountNumber)
          .subscribe(
            transactions => {
              if (transactions.length > 5) {
                this.allowNext = true;
              }
              this.transactions = transactions;
              this.current = 0;
              this.toShowTransactions = this.transactions.slice(this.current, this.current + 5);
            },
            error => console.log(error)
          )
      }

    }, (reason) => {
    });
  }

}
