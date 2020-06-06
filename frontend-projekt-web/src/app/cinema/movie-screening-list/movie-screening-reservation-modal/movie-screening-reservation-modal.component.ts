import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { MovieScreening } from '../../model/movieScreening';
import { ReservationSeat } from '../../model/reservationSeat';
import { ReservationsRestService } from '../../shared/services/reservations-rest.service';
import { n_rows, n_columns } from '../../constants/hallSize'

@Component({
  selector: 'app-movie-screening-reservation-modal',
  templateUrl: './movie-screening-reservation-modal.component.html',
  styleUrls: ['./movie-screening-reservation-modal.component.css']
})
export class MovieScreeningReservationModalComponent implements OnInit {

  @Input()
  screening: MovieScreening;

  takenSeats: ReservationSeat[];

  seatModels: boolean[][];

  modal: any;

  constructor(private modalService: NgbModal, private router: Router, private readonly reservationsRestService: ReservationsRestService) { }

  ngOnInit(): void {
    this.getSeats();
  }

  open(content): void {
    this.generateSeatModel();
    this.modal = this.modalService.open(content);
    console.log(this.seatModels);
  }

  getSeats(): void {
    this.reservationsRestService.findAllReservationSeatsForScreening(this.screening.id).subscribe(val => {
      this.takenSeats = val;
      console.log(this.takenSeats);
    });
  }

  generateSeatModel(): void {
    var arr = new Array(n_rows);
    for (var i = 0; i < n_rows; i++) {
      arr[i] = new Array(n_columns)
      for (var j = 0; j < n_columns; j++) {
        arr[i][j] = false;
      }
    }
    for (let seat of this.takenSeats) {
      arr[seat.seat.row][seat.seat.column] = true;
    }
    this.seatModels = arr;
  }

}
