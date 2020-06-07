import {Reservation} from '../../model/reservation';
import {SeatDTO} from '../../model/dto/seatDTO';

export interface ReservationDTO {
    reservation: Reservation;
    seatDTOList: Array<SeatDTO>;
    screeningId: number;
}
