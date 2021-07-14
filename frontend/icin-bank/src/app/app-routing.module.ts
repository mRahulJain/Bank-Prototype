import { AdminBlockAccountsComponent } from './components/admin/admin-block-accounts/admin-block-accounts.component';
import { AdminRoutingService } from './services/admin-routing-services/admin-routing.service';
import { TransactionRequestsComponent } from './components/admin/transaction-requests/transaction-requests.component';
import { ChequeRequestsComponent } from './components/admin/cheque-requests/cheque-requests.component';
import { AdminListComponent } from './components/admin/admin-list/admin-list.component';
import { AdminLoginComponent } from './components/admin/admin-login/admin-login.component';
import { AdminComponent } from './components/admin/admin/admin.component';
import { ChequeBooksComponent } from './components/bank/cheque-books/cheque-books.component';
import { TransactionsComponent } from './components/bank/transactions/transactions.component';
import { TransactionsService } from './services/transactions/transactions.service';
import { TransferComponent } from './components/bank/transfer/transfer.component';
import { AccountsComponent } from './components/bank/accounts/accounts.component';
import { ProfileComponent } from './components/bank/profile/profile.component';
import { UserRoutingService } from './services/routing-service/user-routing.service';
import { BankComponent } from './components/bank/bank/bank.component';
import { HomeComponent } from './components/bank/home/home.component';
import { UserServiceService } from './services/users/user-service.service';
import { RegistrationComponent } from './components/auth/registration/registration.component';
import { LoginComponent } from './components/auth/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DataService } from './services/current-user/data.service';
import { AccountService } from './services/account/account.service';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegistrationComponent},
  {path: 'bank', component: BankComponent, canActivateChild: [UserRoutingService],
      children: [
    {path: 'home', component: HomeComponent},
    {path: 'profile', component: ProfileComponent},
    {path: 'accounts', component: AccountsComponent},
    {path: 'transfer', component: TransferComponent},
    {path: 'transactions', component: TransactionsComponent},
    {path: 'cheque-books', component: ChequeBooksComponent},
    {path: '**', component: LoginComponent}
  ]},
  {path: 'admin', component: AdminComponent, canActivateChild: [AdminRoutingService],
      children: [
    {path: 'login', component: AdminLoginComponent},
    {path: 'options', component: AdminListComponent},
    {path: 'blocked-accounts', component: AdminBlockAccountsComponent},
    {path: 'cheque-requests', component: ChequeRequestsComponent},
    {path: 'transaction-requests', component: TransactionRequestsComponent},
    {path: '**', component: AdminLoginComponent}
  ]},
  {path: '**', redirectTo: '/login'}
];

@NgModule({
  providers: [ 
    UserServiceService, 
    DataService, 
    UserRoutingService, 
    AccountService, 
    TransactionsService ,
    AdminRoutingService
  ],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
