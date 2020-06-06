import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieScreeningReservationModalComponent } from './movie-screening-reservation-modal.component';

describe('MovieScreeningReservationModalComponent', () => {
  let component: MovieScreeningReservationModalComponent;
  let fixture: ComponentFixture<MovieScreeningReservationModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieScreeningReservationModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieScreeningReservationModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
