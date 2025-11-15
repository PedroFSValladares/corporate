import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToogleInput } from './toogle-input';

describe('ToogleInput', () => {
  let component: ToogleInput;
  let fixture: ComponentFixture<ToogleInput>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ToogleInput]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ToogleInput);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
