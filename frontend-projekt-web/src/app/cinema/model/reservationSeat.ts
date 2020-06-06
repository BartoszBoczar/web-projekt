import {Seat} from '../model/seat';
import {Reservation} from '../model/reservation';

export interface ReservationSeat {
    id: number;
    reservation: Reservation;
    seat: Seat;
    discount: Discount;
}

enum Discount{
    NONE, STUDENT, CHILD, SENIOR
}
