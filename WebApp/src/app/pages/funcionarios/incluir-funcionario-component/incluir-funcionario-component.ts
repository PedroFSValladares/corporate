import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import { Location } from '@angular/common';
import {SelectorOption} from '../../../model/SelectorOption';
import {CargoService} from '../../../services/cargo-service/cargo-service';

@Component({
  selector: 'app-incluir-funcionario-component',
  templateUrl: './incluir-funcionario-component.html',
  styleUrl: './incluir-funcionario-component.css'
})
export class IncluirFuncionarioComponent implements OnInit {
  protected cargoOption: SelectorOption[] = [];

  constructor(private location:Location, private cargoService:CargoService, private cdr : ChangeDetectorRef) {


  }


  protected voltarPagina() {
    this.location.back();
  }

  ngOnInit(): void {
    this.cargoService.obterCargos().subscribe({
      next: result => {
        this.cargoOption = result.data.map(item => new SelectorOption(item.id.toString(), item.nome))
        this.cdr.detectChanges();
      }
    })
  }
}
