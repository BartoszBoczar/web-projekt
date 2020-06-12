import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { MovieScreeningsRestService } from './movie-screenings-rest.service';

describe('MovieScreeningsRestService', () => {
  let service: MovieScreeningsRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ]
    });
    service = TestBed.inject(MovieScreeningsRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

});
