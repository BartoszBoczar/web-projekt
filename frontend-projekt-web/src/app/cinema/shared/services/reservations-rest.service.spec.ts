import { TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { ReservationsRestService } from './reservations-rest.service';

describe('ReservationsRestService', () => {
  let service: ReservationsRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientModule ]
    });
    service = TestBed.inject(ReservationsRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
