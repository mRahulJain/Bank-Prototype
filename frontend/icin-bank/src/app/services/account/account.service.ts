import { Observable } from 'rxjs';
import { Accounts } from './../../model/accounts';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  // private baseURL = 'http://localhost:9090';
  private baseURL = `${environment.apiUrl}:9090`;
  // private baseURL = 'http://icinbank.ap-south-1.elasticbeanstalk.com';

  constructor(private http: HttpClient) { }

  getAccountByNumber(accountNumber: string) : Observable<Accounts> {
    return this.http.get<Accounts>(`${this.baseURL}/accounts/${accountNumber}`)
  }
}
