import {ReservationSeat} from '../../model/reservationSeat';

export interface ReservationSeatDTO {
    reservationSeat: ReservationSeat;
    reservationId: number;
    seatId: number;
}