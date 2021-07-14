import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChequeRequestsComponent } from './cheque-requests.component';

describe('ChequeRequestsComponent', () => {
  let component: ChequeRequestsComponent;
  let fixture: ComponentFixture<ChequeRequestsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChequeRequestsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChequeRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
