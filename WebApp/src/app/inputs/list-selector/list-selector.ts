import { Component } from '@angular/core';
import {BasicInput} from '../basic-input/basic-input';

@Component({
  selector: 'app-list-selector',
  imports: [

  ],
  templateUrl: './list-selector.html',
  styleUrl: './list-selector.css'
})
export class ListSelector extends BasicInput<Object[]>{
  itensSelecionados:Object[]|undefined = this.inputValue();
  itensParaSelecionar:Object[] = [];
  permitirReplicas:boolean = true;

  addItem(event:Event){
    event.preventDefault();
  }
}
