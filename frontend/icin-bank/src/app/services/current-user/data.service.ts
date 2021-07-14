import { Users } from './../../model/users';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private user: Users = null;
  private isSafe: boolean = false;

  constructor() { }

  public getUser() : Users {
    return this.user;
  }

  public setUser(user: Users) {
    this.user = user;
  }

  public getIsSafe() : boolean {
    return this.isSafe;
  }

  public setIsSafe(isSafe: boolean) {
    this.isSafe = isSafe;
  }

}
