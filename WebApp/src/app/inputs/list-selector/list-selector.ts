import {ChangeDetectorRef, Component, input, OnInit, output} from '@angular/core';
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
  itens:Map<number, KeyValuePairItem<string, string>> = new Map();
  input:FormControl = new FormControl();
  index:number = 0;

  constructor(private cdr : ChangeDetectorRef) {
  }

  ngOnInit(): void {
    for(this.index; this.index < this.inputValue().length; this.index++){
      this.itens.set(this.index, this.inputValue()[this.index]);
    }
  }

  addItem(event: Event): void {
    event.preventDefault();
    this.index += 1;
    this.itens.set(this.index ,this.selectorItens().filter(item => item.key! == this.input.value)[0]);
    this.inputValueChange.emit(Array.from(this.itens.values()))
    this.input.setValue("");
  }

  deleteItem(event:Event, deletedItemIndex:number){
    event.preventDefault();
    this.itens.delete(deletedItemIndex);
    this.inputValueChange.emit(Array.from(this.itens.values()))
  }
}
