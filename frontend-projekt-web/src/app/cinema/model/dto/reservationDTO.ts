import {Reservation} from '../../model/reservation';
import {SeatDTO} from '../dto/SeatDTO';

export interface ReservationDTO {
    reservation: Reservation;
    seatDTOList: Array<SeatDTO>;
    screeningId: number;
}