import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { MovieScreening } from '../../model/movieScreening';
import { ReservationSeat } from '../../model/reservationSeat';
import { Seat } from '../../model/seat';
import { SeatDTO } from '../../model/dto/seatDTO';
import { ReservationsRestService } from '../../shared/services/reservations-rest.service';
import { nRows, nColumns } from '../../constants/hallSize';
import { SeatRepresentationComponent } from '../../movie-screening-list/movie-screening-reservation-modal/seat-representation/seat-representation.component';
import {FormGroup, FormControl, ReactiveFormsModule, Validators} from '@angular/forms';

@Component({
  selector: 'app-movie-screening-reservation-modal',
  templateUrl: './movie-screening-reservation-modal.component.html',
  styleUrls: ['./movie-screening-reservation-modal.component.css'],
  template: '<app-seat-representation (selectedSeat)="receiveSelectedSeat($event)"></app-seat-representation>'
})
export class MovieScreeningReservationModalComponent implements OnInit {

  reservationForm: FormGroup;

  @Input()
  screening: MovieScreening;

  takenSeats: Array<ReservationSeat>;

  seatModels: any;

  selectedSeats: Array<Seat> = [];

  modal: any;

  constructor(private modalService: NgbModal, private router: Router, private readonly reservationsRestService: ReservationsRestService) { }

  ngOnInit(): void {
    this.getSeats();
    this.reservationForm = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.minLength(3)]),
      surname: new FormControl('', [Validators.required, Validators.minLength(3)]),
      email: new FormControl('', [Validators.required, Validators.minLength(3), Validators.pattern('[^ @]*@[^ @]*')])
    });
  }

  open(content): void {
    this.getSeats();
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

  onClickMakeReservation(userForm): void {
    const reservationObj = { name: userForm.form.value.name, surname: userForm.form.value.surname, email: userForm.form.value.email};
    const seatDTOList = [];
    for (const s of this.selectedSeats) {
      seatDTOList.push({seat: { row: s.row, column: s.column }, hallId: this.screening.hall.id});
    }
    const finalObj = { reservation: reservationObj, seatDTOList,
      screeningId: this.screening.id};
    console.log(finalObj);
    this.reservationsRestService.saveReservation(finalObj).subscribe(v => console.log(v));
    this.modal.close();
    window.location.reload();
  }
}
