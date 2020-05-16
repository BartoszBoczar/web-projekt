import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {Movie} from '../model/movie';
import {Observable} from 'rxjs';
import {MoviesRestService} from '../shared/services/movies-rest.service';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MovieListResolver implements Resolve<Movie[] | null> {

  constructor(private readonly moviesService: MoviesRestService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Movie[] | null> | Movie[] | null {
    return this.moviesService.findAll();
  }

}
