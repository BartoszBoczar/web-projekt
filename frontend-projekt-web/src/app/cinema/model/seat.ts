import {Hall} from '../model/hall';

export interface Seat {
    id: number;
    hall: Hall;
    row: number;
    column: number;
}
