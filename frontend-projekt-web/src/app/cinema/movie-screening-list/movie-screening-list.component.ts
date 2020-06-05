import { Component, OnInit } from '@angular/core';
import { MovieScreening } from '../model/movieScreening';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-movie-screening-list',
  templateUrl: './movie-screening-list.component.html',
  styleUrls: ['./movie-screening-list.component.css']
})
export class MovieScreeningListComponent implements OnInit {

  screenings: MovieScreening[];

  constructor(private readonly route: ActivatedRoute) { }

  ngOnInit(): void {
    this.screenings = this.route.snapshot.data.screenings.sort((a, b) => {
      return a.time > b.time ? 1 : a.time < b.time ? - 1 : 0;
    });
    console.log('----Screenings----');
    console.log(this.screenings);
  }

}
