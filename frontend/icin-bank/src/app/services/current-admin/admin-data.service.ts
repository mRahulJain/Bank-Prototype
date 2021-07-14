import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminDataService {

  private isSafe: boolean = false;

  constructor() { }

  public getIsSafe() : boolean {
    return this.isSafe;
  }

  public setIsSafe(isSafe: boolean) {
    this.isSafe = isSafe;
  }
}
