import {Component, input} from '@angular/core';
import {CargoResumido} from '../../model/CargoResumido';
import {SelectorOption} from '../../model/SelectorOption';
import {BasicInput} from '../basic-input/basic-input';

@Component({
  selector: 'app-basic-selector',
  imports: [],
  templateUrl: './basic-selector.html',
  styleUrl: './basic-selector.css'
})
export class BasicSelector extends BasicInput{
  itens = input<SelectorOption[]>();
}
