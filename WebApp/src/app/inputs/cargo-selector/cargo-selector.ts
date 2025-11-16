import {ChangeDetectorRef, Component, input, OnInit, output} from '@angular/core';
import {SelectorOption} from '../../model/SelectorOption';
import {CargoService} from '../../services/cargo-service/cargo-service';
import {BasicSelector} from '../basic-selector/basic-selector';
import {BasicInput} from '../basic-input/basic-input';
import {InputLabel} from '../../directives/input-label';
import {CargoResumido} from '../../model/CargoResumido';
import {SelectName} from '../../directives/select-name';
import {SelectId} from '../../directives/select-id';

@Component({
  selector: 'app-cargo-selector',
  imports: [
    BasicSelector,
    InputLabel,
    SelectName,
    SelectId
  ],
  templateUrl: './cargo-selector.html',
  styleUrl: './cargo-selector.css'
})
export class CargoSelector implements OnInit {
  cargos : SelectorOption[] = []
  carregarTudo = input<boolean>(true)
  cargoSelecionado = input<number>();
  valorVazio = input<boolean>(true);
  inputValue = input<string>('');
  desabilitado = input<boolean>(false);
  idCargoSelecionado : string = '';
  idCargoSelecionadoChange = output<CargoResumido>();

  constructor(private cargoService:CargoService, private cdr: ChangeDetectorRef) {

  }

  ngOnInit(): void {
        if(this.carregarTudo()){
          this.cargoService.obterCargos().subscribe({
            next: result => {
              this.cargos = result.data.map(cargo => new SelectorOption(cargo.id.toString(), cargo.nome))
              this.cdr.detectChanges();
            },
            error: error => {
              console.error(error);
            }
          })
        }else{
          this.cargoService.obterCargoPorId(Number(this.inputValue())).subscribe({
            next: result => {
              this.cargos.push({value: result.data.id.toString(), name:result.data.nome});
              this.cdr.detectChanges();
            },
            error: error => {
              console.error(error);
            }
          })
        }
    }
}
