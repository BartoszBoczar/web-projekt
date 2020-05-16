import { Component, OnInit } from '@angular/core';
import { Movie } from '../model/movie';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

    movies: Movie[];

  constructor(private readonly route: ActivatedRoute) { }

  ngOnInit(): void {
    this.movies = this.route.snapshot.data.movies;
    console.log("----Movies----")
    console.log(this.movies)
  }

}
