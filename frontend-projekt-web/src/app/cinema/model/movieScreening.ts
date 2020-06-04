import {Movie} from 'movie';
import {Hall} from 'hall';

export interface MovieScreening {
    id: number;
    movie: Movie;
    hall: Hall;
    beginTime: Date;
    price: number;
}
