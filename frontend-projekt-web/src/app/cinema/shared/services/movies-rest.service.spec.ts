import {TestBed} from '@angular/core/testing';
import {MoviesRestService} from './movies-rest.service';
import { HttpClientModule } from '@angular/common/http';

describe('MoviesRest.ServiceService', () => {
  let service: MoviesRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientModule ]
    });
    service = TestBed.inject(MoviesRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
