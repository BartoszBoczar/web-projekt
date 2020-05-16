import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Movie} from '../../model/movie';

@Injectable({
  providedIn: 'root'
})
export class MoviesRestService {

  constructor(private readonly http: HttpClient) {
  }

  findAll(): Observable<Movie[]> {
    return this.http.get<Movie[]>('/api/movies');
  }

  findMovieById(movieId: number): Observable<Movie> {
    return this.http.get<Movie>('/api/movies/' + movieId);
  }

}
