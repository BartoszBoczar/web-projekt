import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {MovieScreening} from '../model/movieScreening';
import {Observable} from 'rxjs';
import {MovieScreeningsRestService} from '../shared/services/movie-screenings-rest.service';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MovieScreeningListResolver implements Resolve<MovieScreening[] | null> {

  constructor(private readonly movieScreeningService: MovieScreeningsRestService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<MovieScreening[] | null> | MovieScreening[] | null {
    const param = 'id';
    return this.movieScreeningService.findScreeningByMovieId(route.params[param]);
  }

}
