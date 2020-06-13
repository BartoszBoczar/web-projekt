import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ReservationsRestService } from './reservations-rest.service';

describe('ReservationsRestService', () => {
  let service: ReservationsRestService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ]
    });
    service = TestBed.inject(ReservationsRestService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return empty list', () => {
        service.findAllReservationSeatsForScreening(12)
            .subscribe(res => {
              expect(res.length).not.toBeTruthy();
            });
        const request = httpMock.expectOne('/api/reservationSeats/unavailableForScreening/12');
        request.flush([]);
  });

  it('should return revervation seats', () => {
          service.findAllReservationSeatsForScreening(12)
              .subscribe(res => {
                expect(res[0].reservation.name).toBe('name');
              });
          const request = httpMock.expectOne('/api/reservationSeats/unavailableForScreening/12');
          request.flush([{id: 12,
                          reservation: {name: 'name', surname: 'surname', email: 'email'},
                          seat: {hall: {id: 777}, row: 7, column: 13}}
                        ]);
  });

  it('should return nothing on failed save', () => {
        service.saveReservation({reservation: {name: 'name', surname: 'surname', email: 'email'}, seatDTOList: [], screeningId: 12})
            .subscribe(res => {
              expect(res).not.toBeTruthy();
            });
        const request = httpMock.expectOne('/api/reservations');
        request.flush('', {status: 204, statusText: 'Failed put'});
  });

  it('should put reservation', () => {
        service.saveReservation({reservation: {name: 'name', surname: 'surname', email: 'email'}, seatDTOList: [], screeningId: 12})
            .subscribe(res => {
              expect(res).toBeTruthy();
            });
        const request = httpMock.expectOne('/api/reservations');
        expect(request.request.body.reservation.name).toBe('name');
  });
});
