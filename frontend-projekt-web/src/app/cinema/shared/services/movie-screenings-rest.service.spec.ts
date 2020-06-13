import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { MovieScreeningsRestService } from './movie-screenings-rest.service';

describe('MovieScreeningsRestService', () => {
  let service: MovieScreeningsRestService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ]
    });
    service = TestBed.inject(MovieScreeningsRestService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return empty array', () => {
    service.findScreeningByMovieId(1)
        .subscribe(res => {
          expect(res.length).not.toBeTruthy();
        });
    const request = httpMock.expectOne('/api/screenings/movieFromNow/1');
    request.flush([]);
  });

  it('should return test data', () => {
      service.findScreeningByMovieId(1)
          .subscribe(res => {
            expect(res[0].movie.title).toBe('test');
          });
      const request = httpMock.expectOne('/api/screenings/movieFromNow/1');
      request.flush([{id: 12,
                      movie: {title: 'test', description: 'ohno',
                      duration: 12, id: 12, image: ''},
                      hall: {id: 11}, time: 12, price: 12},
                    ]);
    });
});
