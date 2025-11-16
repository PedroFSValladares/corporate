import {FuncionarioCompleto} from '../../model/FuncionarioCompleto';
import {SelectorOption} from '../../model/SelectorOption';
import {FuncionarioService} from '../../services/funcionario-service/funcionario-service';
import {CargoService} from '../../services/cargo-service/cargo-service';
import {ChangeDetectorRef} from '@angular/core';


export class FuncionariosPage{
  funcionario : FuncionarioCompleto|null = null;
  cargos : SelectorOption[] = []
  estados : SelectorOption[] = []

  constructor(private funcionarioService: FuncionarioService,
              private cargoService: CargoService,
              private cdr : ChangeDetectorRef,) {
  }

  obterFuncionario(funcionarioCpf:string){
    this.funcionarioService.obterFuncionarioPorCpf(funcionarioCpf).subscribe({
      next: result => {
        this.funcionario = result.data
        console.log(this.funcionario);
        this.cdr.detectChanges()
      },
      error: error => {
        console.error(error);
      }
    })
  }

  obterCargos(){
    this.cargoService.obterCargos().subscribe({
      next: result => {
        this.cargos = result.data.map(cargo => new SelectorOption(cargo.id.toString(), cargo.nome))
        this.cdr.detectChanges();
      },
      error: error => {
        console.error(error);
      }
    })
  }

  setEstados(){
    let estados : string[] = [
      'AC',
      'AL',
      'AP',
      'AM',
      'BA',
      'CE',
      'ES',
      'GO',
      'MA',
      'MT',
      'MS',
      'MG',
      'PA',
      'PB',
      'PR',
      'PE',
      'PI',
      'RJ',
      'RN',
      'RS',
      'RO',
      'RR',
      'SC',
      'SP',
      'SE',
      'TO'
    ]

    this.estados = estados.map(estado => new SelectorOption(estado, estado));
  }
}
