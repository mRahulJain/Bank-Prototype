import { TestBed } from '@angular/core/testing';

import { UserRoutingService } from './user-routing.service';

describe('UserRoutingService', () => {
  let service: UserRoutingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserRoutingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
