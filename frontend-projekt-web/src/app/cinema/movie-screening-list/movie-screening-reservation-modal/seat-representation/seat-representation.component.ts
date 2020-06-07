import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-seat-representation',
  templateUrl: './seat-representation.component.html',
  styleUrls: ['./seat-representation.component.css']
})
export class SeatRepresentationComponent implements OnInit {

  buttonSelected: boolean = false;

  @Input()
  model: any;

  @Output()
  selectedSeat = new EventEmitter<{row: number, column: number}>();

  constructor() { }

  ngOnInit(): void {
  }

  selectSeat(): void {
    this.selectedSeat.emit({row: this.model.row, column: this.model.column});
    this.buttonSelected = !this.buttonSelected;
  }
}
