import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalharFuncionarioComponent } from './detalhar-funcionario-component';

describe('DetalharFuncionarioComponent', () => {
  let component: DetalharFuncionarioComponent;
  let fixture: ComponentFixture<DetalharFuncionarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetalharFuncionarioComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetalharFuncionarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
