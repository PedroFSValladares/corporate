import {Component, input, OnInit, output} from '@angular/core';
import {BasicInput} from '../basic-input/basic-input';
import {BasicSelector} from '../basic-selector/basic-selector';
import {SelectorOption} from '../../model/SelectorOption';
import {FormControl, ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-list-selector',
  imports: [
    ReactiveFormsModule

  ],
  templateUrl: './list-selector.html',
  styleUrl: './list-selector.css'
})
export class ListSelector implements OnInit {
  inputValue = input<string[]>([]);
  inputValueChange = output<string[]>();
  selectorItens = input<SelectorOption[]>([]);
  itens:string[] = [];
  input:FormControl = new FormControl();

  ngOnInit(): void {
      this.itens = this.inputValue();
  }

  addItem(event: Event): void {
    event.preventDefault();
    this.itens.push(this.selectorItens().filter(item => item.value == this.input.value)[0].name)
    this.inputValueChange.emit(this.itens)
    this.input.setValue("");
  }
}
