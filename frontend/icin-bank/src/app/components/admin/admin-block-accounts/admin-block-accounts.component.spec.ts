import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminBlockAccountsComponent } from './admin-block-accounts.component';

describe('AdminBlockAccountsComponent', () => {
  let component: AdminBlockAccountsComponent;
  let fixture: ComponentFixture<AdminBlockAccountsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminBlockAccountsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminBlockAccountsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
