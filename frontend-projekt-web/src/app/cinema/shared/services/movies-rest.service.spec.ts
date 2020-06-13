import {TestBed} from '@angular/core/testing';
import {MoviesRestService} from './movies-rest.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

describe('MoviesRestService', () => {
  let service: MoviesRestService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ]
    });
    service = TestBed.inject(MoviesRestService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return empty movie list', () => {
      service.findAll()
          .subscribe(res => {
            expect(res.length).not.toBeTruthy();
          });
      const request = httpMock.expectOne('/api/movies');
      request.flush([]);
  });

  it('should return test movie', () => {
      service.findAll()
          .subscribe(res => {
            expect(res[0].title).toBe('test');
          });
      const request = httpMock.expectOne('/api/movies');
      request.flush([{title: 'test', description: 'ohno', duration: 12, id: 12, image: ''}, ]);
  });

  it('should return no movie', () => {
      service.findMovieById(777)
          .subscribe(res => {
            expect(res).not.toBeTruthy();
          });
      const request = httpMock.expectOne('/api/movies/777');
      request.flush(null);
  });

  it('should return test movie', () => {
      service.findMovieById(12)
          .subscribe(res => {
            expect(res.title).toBe('test');
          });
      const request = httpMock.expectOne('/api/movies/12');
      request.flush({title: 'test', description: 'ohno', duration: 12, id: 12, image: ''});
  });
});
