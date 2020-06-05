import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MovieListComponent } from './cinema/movie-list/movie-list.component';
import { MovieListResolver } from './cinema/movie-list/movie-list.resolver';
import { MovieScreeningListComponent } from './cinema/movie-screening-list/movie-screening-list.component';
import { MovieScreeningListResolver } from './cinema/movie-screening-list/movie-screening-list.resolver';

const routes: Routes = [
    {
        path: 'movies',
        component: MovieListComponent,
        resolve: {
          movies: MovieListResolver
        }
    },
    {
        path: 'movies/:id',
        component: MovieScreeningListComponent,
        resolve: {
          screenings: MovieScreeningListResolver
        }
    },
    {
        path: '',
        redirectTo: '/movies',
        pathMatch: 'full'
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
