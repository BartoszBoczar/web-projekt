import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { RouterTestingModule } from '@angular/router/testing';
import { ReservationsRestService } from '../../shared/services/reservations-rest.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { MovieScreeningReservationModalComponent } from './movie-screening-reservation-modal.component';

describe('MovieScreeningReservationModalComponent', () => {
  let component: MovieScreeningReservationModalComponent;
  let fixture: ComponentFixture<MovieScreeningReservationModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieScreeningReservationModalComponent ],
      imports: [ RouterTestingModule, HttpClientTestingModule ],
      providers: [ NgbModal, ReservationsRestService ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieScreeningReservationModalComponent);
    component = fixture.componentInstance;
    const movie = {title: 'test', description: 'ohno', duration: 12, id: 12, image: ''};
    const hall = {id: 11};
    component.screening = {id: 12, movie, hall, time: new Date(12), price: 12};
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
