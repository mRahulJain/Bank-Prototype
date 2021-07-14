import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChequeBooksComponent } from './cheque-books.component';

describe('ChequeBooksComponent', () => {
  let component: ChequeBooksComponent;
  let fixture: ComponentFixture<ChequeBooksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChequeBooksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChequeBooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
