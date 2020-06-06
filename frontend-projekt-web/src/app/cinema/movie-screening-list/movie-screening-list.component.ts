import { Component, OnInit } from '@angular/core';
import { MovieScreening } from '../model/movieScreening';
import { ActivatedRoute } from '@angular/router';
import { Movie } from '../model/movie';

@Component({
  selector: 'app-movie-screening-list',
  templateUrl: './movie-screening-list.component.html',
  styleUrls: ['./movie-screening-list.component.css']
})
export class MovieScreeningListComponent implements OnInit {

  movie: Movie;

  screenings: MovieScreening[];

  constructor(private readonly route: ActivatedRoute) { }

  ngOnInit(): void {
    this.screenings = this.route.snapshot.data.screenings;
    if (this.screenings.length !== 0) { this.movie = this.screenings[0].movie; }
    console.log('----Screenings----');
    console.log(this.screenings);
  }

}
