import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieListPanelComponent } from './movie-list-panel.component';

describe('MovieListPanelComponent', () => {
  let component: MovieListPanelComponent;
  let fixture: ComponentFixture<MovieListPanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieListPanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieListPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
