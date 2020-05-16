import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MovieListComponent} from './cinema/movie-list/movie-list.component';
import {MovieListResolver} from './cinema/movie-list/movie-list.resolver';


const routes: Routes = [
    {
        path: 'movies',
        component: MovieListComponent,
        resolve: {
          movies: MovieListResolver
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
