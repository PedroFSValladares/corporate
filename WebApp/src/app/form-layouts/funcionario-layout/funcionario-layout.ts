import {ChangeDetectorRef, Component, input, OnInit} from '@angular/core';
import {BasicInput} from "../../inputs/basic-input/basic-input";
import {BasicSelector} from "../../inputs/basic-selector/basic-selector";
import {FuncionarioCompleto} from '../../model/FuncionarioCompleto';
import {SelectorOption} from '../../model/SelectorOption';
import {Division} from '../../division/division';

@Component({
  selector: 'app-funcionario-layout',
  imports: [
    BasicInput,
    BasicSelector,
    Division
  ],
  templateUrl: './funcionario-layout.html',
  styleUrl: './funcionario-layout.css'
})
export class FuncionarioLayout implements OnInit {
  funcionario = input<FuncionarioCompleto>(new FuncionarioCompleto());
  cargoOption = input<SelectorOption[]>([new SelectorOption("", "")])
  bloqueado = input<boolean>(false);
  UF : SelectorOption[] = []


  ngOnInit(): void {
    this.UF.push(new SelectorOption("0", this.funcionario().endereco.uf))
  }
}
