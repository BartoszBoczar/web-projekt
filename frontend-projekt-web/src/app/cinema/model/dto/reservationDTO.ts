import {Reservation} from '../../model/reservation';
import {ReservationSeatDTO} from '../dto/reservationSeatDTO';

export interface ReservationDTO {
    reservation: Reservation;
    reservationSeatDTOList: Array<ReservationSeatDTO>;
    screeningId: number;
}