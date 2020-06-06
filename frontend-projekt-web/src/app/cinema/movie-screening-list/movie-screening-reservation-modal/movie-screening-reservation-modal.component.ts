import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { MovieScreening } from '../../model/movieScreening';
import { ReservationSeat } from '../../model/reservationSeat';
import { ReservationsRestService } from '../../shared/services/reservations-rest.service';

@Component({
  selector: 'app-movie-screening-reservation-modal',
  templateUrl: './movie-screening-reservation-modal.component.html',
  styleUrls: ['./movie-screening-reservation-modal.component.css']
})
export class MovieScreeningReservationModalComponent implements OnInit {

  @Input()
  screening: MovieScreening;

  takenSeats: ReservationSeat[];

  modal: any;

  constructor(private modalService: NgbModal, private router: Router, private readonly reservationsRestService: ReservationsRestService) { }

  ngOnInit(): void {
    this.getSeats();
  }

  open(content): void {
    this.modal = this.modalService.open(content);
  }

  getSeats(): void {
    this.reservationsRestService.findAllReservationSeatsForScreening(this.screening.id).subscribe(val => {
      this.takenSeats = val;
      console.log(val);
      });
  }

}
