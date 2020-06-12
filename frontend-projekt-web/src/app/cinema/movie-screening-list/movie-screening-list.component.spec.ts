import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { By } from '@angular/platform-browser';
import { MovieScreeningListComponent } from './movie-screening-list.component';

class MockRoute {
  movie = {title: 'test', description: 'ohno', duration: 12, id: 12, image: ''};
  hall = {id: 11};
  snapshot = {
    data: {  screenings: [ {id: 12, movie: this.movie, hall: this.hall, time: 12, price: 12} ] }
  };
}

describe('MovieScreeningListComponent', () => {
  let component: MovieScreeningListComponent;
  let fixture: ComponentFixture<MovieScreeningListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieScreeningListComponent ],
      providers: [ { provide: ActivatedRoute, useClass: MockRoute} ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieScreeningListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render movie details', () => {
    expect(fixture.debugElement.query(By.css('div')).nativeElement.textContent)
        .toContain('ohno');
  });

  it('should render screenings table', () => {
    expect(fixture.debugElement.query(By.css('table')).nativeElement.textContent)
         .toContain('11');
  });
});
