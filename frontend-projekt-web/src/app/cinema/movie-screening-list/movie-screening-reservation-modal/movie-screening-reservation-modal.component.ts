import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { MovieScreening } from '../../model/movieScreening';
import { ReservationSeat } from '../../model/reservationSeat';
import { ReservationDTO } from '../../model/dto/reservationDTO';
import { SeatDTO } from '../../model/dto/seatDTO';
import { Seat } from '../../model/seat';
import { ReservationsRestService } from '../../shared/services/reservations-rest.service';
import { nRows, nColumns } from '../../constants/hallSize';
import { SeatRepresentationComponent } from '../../movie-screening-list/movie-screening-reservation-modal/seat-representation/seat-representation.component';


@Component({
  selector: 'app-movie-screening-reservation-modal',
  templateUrl: './movie-screening-reservation-modal.component.html',
  styleUrls: ['./movie-screening-reservation-modal.component.css'],
  template: '<app-seat-representation (selectedSeat)="receiveSelectedSeat($event)"></app-seat-representation>'
})
export class MovieScreeningReservationModalComponent implements OnInit {

  @Input()
  screening: MovieScreening;

  takenSeats: Array<ReservationSeat>;

  seatModels: any;

  selectedSeats: Array<Seat> = [];

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
    });
  }

  generateSeatModel(): void {
    const arr = new Array(nRows);
    for (let i = 0; i < nRows; i++) {
      arr[i] = new Array(nColumns);
      for (let j = 0; j < nColumns; j++) {
        arr[i][j] = { row: i, column: j, taken: false};
      }
    }
    for (const seat of this.takenSeats) {
      arr[seat.seat.row][seat.seat.column].taken = true;
    }
    this.seatModels = arr;
  }

  receiveSelectedSeat(event): void {
    for (let i = 0; i < this.selectedSeats.length; i++) {
      if (this.selectedSeats[i].row === event.row && this.selectedSeats[i].column === event.column) {
        this.selectedSeats.splice(i, 1);
        return;
      }
    }
    this.selectedSeats.push({hall: this.screening.hall, row: event.row, column: event.column});
    console.log(this.selectedSeats);
  }

  makeSeatReservationList() {

  }

  onClickMakeReservation(userForm): void {
    const reservationObj = { name: userForm.form.value.name, surname: userForm.form.value.surname, email: userForm.form.value.email};
    const reservationSeatDTOListObj = [];
    //const finalObj = { reservation: reservationObj, reservationSeatDTOList: reservationSeatDTOListObj,
    //    screeningId: this.screening.id};
    //this.reservationsRestService.saveReservation(finalObj);
    window.location.reload();
  }
}
