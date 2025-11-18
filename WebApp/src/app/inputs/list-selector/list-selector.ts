import {ChangeDetectorRef, Component, input, OnInit, output} from '@angular/core';
import {BasicInput} from '../basic-input/basic-input';
import {BasicSelector} from '../basic-selector/basic-selector';
import {SelectorOption} from '../../model/SelectorOption';
import {FormControl, ReactiveFormsModule} from '@angular/forms';
import {KeyValuePairItem} from '../commom/KeyValuePairItem';

@Component({
  selector: 'app-list-selector',
  imports: [
    ReactiveFormsModule

  ],
  templateUrl: './list-selector.html',
  styleUrl: './list-selector.css'
})
export class ListSelector implements OnInit {
  inputValue = input<KeyValuePairItem<string, string>[]>([]);
  inputValueChange = output<KeyValuePairItem<string, string>[]>();
  selectorItens = input<KeyValuePairItem<string, string>[]>([]);
  itens:KeyValuePairItem<string, string>[] = [];
  input:FormControl = new FormControl();

  constructor(private cdr : ChangeDetectorRef) {
  }

  ngOnInit(): void {
      this.itens = this.inputValue();
  }

  addItem(event: Event): void {
    event.preventDefault();
    this.itens.push(this.selectorItens().filter(item => item.key! == this.input.value)[0]);
    this.inputValueChange.emit(this.itens)
    this.input.setValue("");
  }

  deleteItem(event:Event, deletedItem:KeyValuePairItem<string, string>){
    event.preventDefault();
    this.itens = this.itens.filter(item => item.key != deletedItem.key);
    this.inputValueChange.emit(this.itens)
  }
}
