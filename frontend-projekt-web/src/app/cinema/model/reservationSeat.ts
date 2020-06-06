import {Seat} from '../model/seat';
import {Reservation} from '../model/reservation';
import {Discount} from '../model/enumerations/discount';

export interface ReservationSeat {
    id: number;
    reservation: Reservation;
    seat: Seat;
    discount: Discount;
}