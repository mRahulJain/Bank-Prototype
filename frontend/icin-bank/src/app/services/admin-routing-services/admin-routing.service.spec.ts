import { TestBed } from '@angular/core/testing';

import { AdminRoutingService } from './admin-routing.service';

describe('AdminRoutingService', () => {
  let service: AdminRoutingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminRoutingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
