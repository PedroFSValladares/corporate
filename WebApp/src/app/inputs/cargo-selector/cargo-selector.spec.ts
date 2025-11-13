import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CargoSelector } from './cargo-selector';

describe('CargoSelector', () => {
  let component: CargoSelector;
  let fixture: ComponentFixture<CargoSelector>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CargoSelector]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CargoSelector);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
