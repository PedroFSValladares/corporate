import {Component, input} from '@angular/core';
import {BasicInput} from '../basic-input/basic-input';
import {BasicSelector} from '../basic-selector/basic-selector';
import {CargoSelector} from '../cargo-selector/cargo-selector';
import {SelectorOption} from '../../model/SelectorOption';

@Component({
  selector: 'app-estado-selector',
  imports: [
    BasicSelector
  ],
  templateUrl: './estado-selector.html',
  styleUrl: './estado-selector.css'
})
export class EstadoSelector extends BasicInput<string>{
  estados : string[] = [
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
  estadoOtpions : SelectorOption[] = this.estados.map(estado => new SelectorOption(estado, estado));
  valorVazio = input<boolean>(true);
}
