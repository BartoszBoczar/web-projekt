import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeatRepresentationComponent } from './seat-representation.component';

describe('SeatRepresentationComponent', () => {
  let component: SeatRepresentationComponent;
  let fixture: ComponentFixture<SeatRepresentationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeatRepresentationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeatRepresentationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
