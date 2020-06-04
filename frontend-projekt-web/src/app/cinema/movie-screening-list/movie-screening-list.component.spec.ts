import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieScreeningListComponent } from './movie-screening-list.component';

describe('MovieScreeningListComponent', () => {
  let component: MovieScreeningListComponent;
  let fixture: ComponentFixture<MovieScreeningListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieScreeningListComponent ]
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
});
