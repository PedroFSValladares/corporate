import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BasicSelector } from './basic-selector';

describe('BasicSelector', () => {
  let component: BasicSelector;
  let fixture: ComponentFixture<BasicSelector>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BasicSelector]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BasicSelector);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
