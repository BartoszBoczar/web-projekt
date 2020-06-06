import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-seat-representation',
  templateUrl: './seat-representation.component.html',
  styleUrls: ['./seat-representation.component.css']
})
export class SeatRepresentationComponent implements OnInit {

  @Input()
  available: boolean;

  constructor() { }

  ngOnInit(): void {
  }

}
