import {Component, input} from '@angular/core';
import {CargoResumido} from '../../model/CargoResumido';
import {SelectorOption} from './SelectorOption';

@Component({
  selector: 'app-basic-selector',
  imports: [],
  templateUrl: './basic-selector.html',
  styleUrl: './basic-selector.css'
})
export class BasicSelector {
  label = input<string>();
  inputName = input<string>();
  inputId = input<string>();
  itens = input<SelectorOption[]>();
}
