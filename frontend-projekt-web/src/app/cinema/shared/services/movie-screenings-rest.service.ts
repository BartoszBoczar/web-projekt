import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {MovieScreening} from '../../model/movieScreening';

@Injectable({
  providedIn: 'root'
})
export class MovieScreeningsRestService {

  constructor(private readonly http: HttpClient) { }

  findScreeningByMovieId(movieId: number): Observable<MovieScreening[]> {
      return this.http.get<MovieScreening[]>('/api/screenings/movie/' + movieId);
  }

}
