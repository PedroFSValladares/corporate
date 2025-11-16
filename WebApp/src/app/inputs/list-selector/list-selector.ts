import {Component, input} from '@angular/core';
import {BasicInput} from '../basic-input/basic-input';

@Component({
  selector: 'app-list-selector',
  imports: [

  ],
  templateUrl: './list-selector.html',
  styleUrl: './list-selector.css'
})
export class ListSelector extends BasicInput{
  itensSelecionados:Object[]|undefined = [];
  itensParaSelecionar = input<Object[]>([]);

  addItem(event:Event){
    event.preventDefault();
  }
}
