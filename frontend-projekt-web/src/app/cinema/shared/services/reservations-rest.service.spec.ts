import { TestBed } from '@angular/core/testing';

import { ReservationsRestService } from './reservations-rest.service';

describe('ReservationsRestService', () => {
  let service: ReservationsRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReservationsRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
