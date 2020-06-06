import {Movie} from '../model/movie';
import {Hall} from '../model/hall';

export interface MovieScreening {
    id: number;
    movie: Movie;
    hall: Hall;
    time: Date;
    price: number;
}
