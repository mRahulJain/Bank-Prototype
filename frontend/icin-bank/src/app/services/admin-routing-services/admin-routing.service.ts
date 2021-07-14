import { ActivatedRouteSnapshot, CanActivateChild, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminDataService } from '../current-admin/admin-data.service';

@Injectable({
  providedIn: 'root'
})
export class AdminRoutingService implements CanActivateChild {

  constructor(private adminService: AdminDataService, private router: Router) { }
  canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    if (this.adminService.getIsSafe() == true) {
      return true;
    }

    let url = childRoute.url.toString();
    if(url === 'login') {
      return true;
    }

    this.router.navigate(['admin/login']);
    return false;
  }
}
