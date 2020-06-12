import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { By } from '@angular/platform-browser';
import { MovieListComponent } from './movie-list.component';

class MockRoute {
  snapshot = {
    data: {  movies: [ {title: 'test', description: 'ohno', duration: 12, id: 12, image: ''} ] }
  };
}

describe('MovieListComponent', () => {
  let component: MovieListComponent;
  let fixture: ComponentFixture<MovieListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieListComponent ],
      providers: [ { provide: ActivatedRoute, useClass: MockRoute} ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should not be empty', () => {
        const compiled = fixture.nativeElement;
        expect(fixture.debugElement.query(By.css('section')).nativeElement.textContent)
            .not.toContain('No movies found');
  });
});
