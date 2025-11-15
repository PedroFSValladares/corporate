import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstadoSelector } from './estado-selector';

describe('EstadoSelector', () => {
  let component: EstadoSelector;
  let fixture: ComponentFixture<EstadoSelector>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EstadoSelector]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EstadoSelector);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
