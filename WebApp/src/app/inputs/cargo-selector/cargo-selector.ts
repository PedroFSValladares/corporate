import {ChangeDetectorRef, Component, input, OnInit} from '@angular/core';
import {BasicInput} from '../basic-input/basic-input';
import {SelectorOption} from '../../model/SelectorOption';
import {CargoService} from '../../services/cargo-service/cargo-service';

@Component({
  selector: 'app-cargo-selector',
  imports: [],
  templateUrl: './cargo-selector.html',
  styleUrl: './cargo-selector.css'
})
export class CargoSelector extends BasicInput implements OnInit {
  itens : SelectorOption[] = []
  carregarTudo = input<boolean>(true)

  constructor(private cargoService:CargoService, private cdr: ChangeDetectorRef) {
    super();
  }

  ngOnInit(): void {
        if(this.carregarTudo()){
          this.cargoService.obterCargos().subscribe({
            next: result => {
              this.itens = result.data.map(cargo => {
                return new SelectorOption(cargo.id.toString(), cargo.nome);
              })
            },
            error: error => {
              console.error(error);
            }
          })
        }else{
          this.cargoService.obterCargoPorId(Number(this.inputValue())).subscribe({
            next: result => {
              this.itens.push(new SelectorOption(result.data.id.toString(), result.data.nome));
              this.cdr.detectChanges();
            },
            error: error => {
              console.error(error);
            }
          })
        }
    }
}
