import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import { Location } from '@angular/common';
import {CargoService} from '../../../services/cargo-service/cargo-service';
import {KeyValuePairItem} from '../../../inputs/commom/KeyValuePairItem';

@Component({
  selector: 'app-incluir-funcionario-component',
  templateUrl: './incluir-funcionario-component.html',
  styleUrl: './incluir-funcionario-component.css'
})
export class IncluirFuncionarioComponent implements OnInit {
  protected cargoOption: KeyValuePairItem<string, string>[] = [];

  constructor(private location:Location, private cargoService:CargoService, private cdr : ChangeDetectorRef) {


  }


  protected voltarPagina() {
    this.location.back();
  }

  ngOnInit(): void {
    this.cargoService.obterCargos().subscribe({
      next: result => {
        this.cargoOption = result.data.map(item => new KeyValuePairItem(item.id.toString(), item.nome))
        this.cdr.detectChanges();
      }
    })
  }
}
