import { AdminRoutingService } from './services/admin-routing-services/admin-routing.service';
import { TransactionsService } from './services/transactions/transactions.service';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RegistrationComponent } from './components/auth/registration/registration.component';
import { FooterComponent } from './components/footer/footer.component';
import { FormsModule } from '@angular/forms';
import { UserServiceService } from './services/users/user-service.service';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/bank/home/home.component';
import { BankComponent } from './components/bank/bank/bank.component';
import { DataService } from './services/current-user/data.service';
import { ProfileComponent } from './components/bank/profile/profile.component';
import { AccountsComponent } from './components/bank/accounts/accounts.component';
import { AccountService } from './services/account/account.service';
import { TransferComponent } from './components/bank/transfer/transfer.component';
import { TransactionsComponent } from './components/bank/transactions/transactions.component';
import { ChequeBooksComponent } from './components/bank/cheque-books/cheque-books.component';
import { AdminLoginComponent } from './components/admin/admin-login/admin-login.component';
import { AdminComponent } from './components/admin/admin/admin.component';
import { AdminListComponent } from './components/admin/admin-list/admin-list.component';
import { ChequeRequestsComponent } from './components/admin/cheque-requests/cheque-requests.component';
import { TransactionRequestsComponent } from './components/admin/transaction-requests/transaction-requests.component';
import { AdminBlockAccountsComponent } from './components/admin/admin-block-accounts/admin-block-accounts.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    RegistrationComponent,
    FooterComponent,
    HomeComponent,
    BankComponent,
    ProfileComponent,
    AccountsComponent,
    TransferComponent,
    TransactionsComponent,
    ChequeBooksComponent,
    LoginComponent,
    AdminLoginComponent,
    AdminComponent,
    AdminListComponent,
    ChequeRequestsComponent,
    TransactionRequestsComponent,
    AdminBlockAccountsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [ UserServiceService, DataService, AccountService, TransactionsService, AdminRoutingService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
