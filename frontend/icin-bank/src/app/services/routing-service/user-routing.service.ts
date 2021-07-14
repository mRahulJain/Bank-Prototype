import { DataService } from './../current-user/data.service';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateChild, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserRoutingService implements CanActivateChild {

  constructor(private router: Router, private dataService: DataService) { }
  canActivateChild(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    if (this.dataService.getIsSafe() == true) {
      return true;
    }

    this.router.navigate(['login']);
    return false;
  }
}
