import {Hall} from '../model/hall';

export interface Seat {
    hall: Hall;
    row: number;
    column: number;
}
