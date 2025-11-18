import {FuncionarioCompleto} from '../../model/FuncionarioCompleto';
import {SelectorOption} from '../../model/SelectorOption';
import {FuncionarioService} from '../../services/funcionario-service/funcionario-service';
import {CargoService} from '../../services/cargo-service/cargo-service';
import {ChangeDetectorRef} from '@angular/core';
import {TransporteService} from '../../services/transporte-service/transporte-service';
import {KeyValuePairItem} from '../../inputs/commom/KeyValuePairItem';


export class FuncionariosPage{
  funcionario : FuncionarioCompleto|null = null;
  cargos : SelectorOption[] = []
  estados : SelectorOption[] = []
  transportes : KeyValuePairItem<string, string>[] = []
  transportesIda : KeyValuePairItem<string, string>[] = []
  transportesVolta : KeyValuePairItem<string, string>[] = []

  constructor(private funcionarioService: FuncionarioService,
              private transporteService: TransporteService,
              private cargoService: CargoService,
              private cdr : ChangeDetectorRef,) {
  }

  obterFuncionario(funcionarioCpf:string){
    this.funcionarioService.obterFuncionarioPorCpf(funcionarioCpf).subscribe({
      next: result => {
        this.funcionario = result.data
        this.transportesToStringArray();
        this.cdr.detectChanges()
      },
      error: error => {
        console.error(error);
      }
    })
  }

  transportesToStringArray(){
    let transportesIda = this.funcionario?.viagens
      .filter(viagem => viagem.tipoViagem == "ida")
      .map(viagem =>
        new KeyValuePairItem(viagem.transporte.codigo, `${viagem.transporte.codigo} - ${viagem.transporte.itinerario}`));
    let transportesVolta = this.funcionario?.viagens
      .filter(viagem => viagem.tipoViagem == "volta")
      .map(viagem =>
        new KeyValuePairItem(viagem.transporte.codigo, `${viagem.transporte.codigo} - ${viagem.transporte.itinerario}`));

    if(transportesIda){
      this.transportesIda = transportesIda
    }
    if(transportesVolta){
      this.transportesVolta = transportesVolta
    }
  }

  obterTransportes(){
    this.transporteService.obterTodos().subscribe({
      next: result => {
        this.transportes = result.data
          .map(transporte => new KeyValuePairItem(transporte.codigo, `${transporte.codigo} - ${transporte.itinerario}`));
        this.cdr.detectChanges();
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
