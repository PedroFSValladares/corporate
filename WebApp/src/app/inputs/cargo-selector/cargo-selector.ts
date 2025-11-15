import {ChangeDetectorRef, Component, input, OnInit} from '@angular/core';
import {BasicInput} from '../basic-input/basic-input';
import {SelectorOption} from '../../model/SelectorOption';
import {CargoService} from '../../services/cargo-service/cargo-service';
import {BasicSelector} from '../basic-selector/basic-selector';

@Component({
  selector: 'app-cargo-selector',
  imports: [
    BasicSelector
  ],
  templateUrl: './cargo-selector.html',
  styleUrl: './cargo-selector.css'
})
export class CargoSelector extends BasicSelector implements OnInit {
  cargos : SelectorOption[] = []
  carregarTudo = input<boolean>(true)
  cargoSelecionado = input<number>();

  constructor(private cargoService:CargoService, private cdr: ChangeDetectorRef) {
    super();
  }

  ngOnInit(): void {
        if(this.carregarTudo()){
          this.cargoService.obterCargos().subscribe({
            next: result => {
              this.cargos = result.data.map(cargo => {
                return new SelectorOption(cargo.id.toString(), cargo.nome);
              })
              this.cdr.detectChanges();
            },
            error: error => {
              console.error(error);
            }
          })
        }else{
          this.cargoService.obterCargoPorId(Number(this.inputValue())).subscribe({
            next: result => {
              this.cargos.push(new SelectorOption(result.data.id.toString(), result.data.nome));
              this.cdr.detectChanges();
            },
            error: error => {
              console.error(error);
            }
          })
        }
    }
}
