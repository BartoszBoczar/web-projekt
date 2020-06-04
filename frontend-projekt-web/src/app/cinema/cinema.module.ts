import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule } from '@angular/forms';
import { MovieListComponent } from './movie-list/movie-list.component';
import { MovieListPanelComponent } from './movie-list/movie-list-panel/movie-list-panel.component';
import { MovieScreeningListComponent } from './movie-screening-list/movie-screening-list.component';


@NgModule({
  declarations: [
    MovieListComponent,
    MovieListPanelComponent,
    MovieScreeningListComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    FormsModule
  ]
})
export class CinemaModule { }
