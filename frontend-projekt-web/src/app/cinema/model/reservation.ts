import {MovieScreening} from '../model/movieScreening';

export interface Reservation {
    id: number;
    screening: MovieScreening;
    name: string;
    surname: string;
    email: string;
}