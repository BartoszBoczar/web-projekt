import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ReservationSeat} from '../../model/reservationSeat';

@Injectable({
  providedIn: 'root'
})
export class ReservationsRestService {

  constructor(private readonly http: HttpClient) { }

  findAllReservationSeatsForScreening(screeningId: number): Observable<ReservationSeat[]> {
    return this.http.get<ReservationSeat[]>('/api/reservationSeats/unavailableForScreening/' + screeningId);
  }
}
