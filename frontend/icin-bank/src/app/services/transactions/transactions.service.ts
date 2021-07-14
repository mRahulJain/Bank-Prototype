import { Message } from 'src/app/model/message';
import { Observable } from 'rxjs';
import { Transactions } from './../../model/transactions';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TransactionsService {

  // private baseURL = 'http://localhost:9090';
  private baseURL = `${environment.apiUrl}:9090`;
  // private baseURL = 'http://icinbank.ap-south-1.elasticbeanstalk.com';

  constructor(private http: HttpClient) { }

  putTransaction(transaction: Transactions) : Observable<Message> {
    return this.http.post<Message>(`${this.baseURL}/transactions/putTransaction`, transaction);
  }

  getTransactions(accountNumber: string) : Observable<Array<Transactions>> {
    return this.http.get<Array<Transactions>>(`${this.baseURL}/transactions/${accountNumber}`);
  }

  getFilteredTransactions(accountNumber: string, startDate: Date, endDate: Date) : Observable<Array<Transactions>> {
    return this.http.get<Array<Transactions>>(`${this.baseURL}/transactions/${accountNumber}/${startDate}/${endDate}`);
  }

  getAllPendingTransaction() : Observable<Array<Transactions>> {
    return this.http.get<Array<Transactions>>(`${this.baseURL}/admin/get-all-pending-transactions`)
  }

  permitTransaction(id: number) : Observable<Message> {
    return this.http.get<Message>(`${this.baseURL}/admin/allow/transaction/${id}`)
  }
}
