import { Component, Input, OnInit } from '@angular/core';
import { Movie } from '../../model/movie';

@Component({
  selector: 'app-movie-list-panel',
  templateUrl: './movie-list-panel.component.html',
  styleUrls: ['./movie-list-panel.component.scss']
})
export class MovieListPanelComponent implements OnInit {

   @Input()
   movie: Movie;

  constructor() { }

  ngOnInit(): void {
  }

}
