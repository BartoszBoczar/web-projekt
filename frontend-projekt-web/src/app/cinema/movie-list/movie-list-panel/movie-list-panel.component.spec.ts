import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
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
    component.movie = {title: 'test', description: 'ohno', duration: 12, id: 12, image: ''};
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render test data', () => {
        const compiled = fixture.nativeElement;
        expect(fixture.debugElement.query(By.css('div')).nativeElement.textContent)
            .toContain('ohno');
  });

});
