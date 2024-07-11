import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayProductCardComponent } from './display-product-card.component';

describe('DisplayProductCardComponent', () => {
  let component: DisplayProductCardComponent;
  let fixture: ComponentFixture<DisplayProductCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DisplayProductCardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayProductCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
