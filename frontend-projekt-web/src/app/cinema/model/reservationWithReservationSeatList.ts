import {Reservation} from '../model/reservation';
import {ReservationSeat} from '../model/reservationSeat';

export interface ReservationWithReservationSeatList {
    reservation: Reservation;
    reservationSeatList: ReservationSeat[];
}