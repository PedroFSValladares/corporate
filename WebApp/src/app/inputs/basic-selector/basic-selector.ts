import {ChangeDetectorRef, Component, input, OnInit, output} from '@angular/core';
import {FormControl, ReactiveFormsModule} from '@angular/forms';
import {KeyValuePairItem} from '../commom/KeyValuePairItem';

@Component({
  selector: 'app-basic-selector',
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './basic-selector.html',
  styleUrl: './basic-selector.css'
})
export class BasicSelector implements OnInit {
  itens = input<KeyValuePairItem<string, string>[]>([]);
  valorVazio = input<boolean>(true);
  desabilitado = input<boolean>(false);
  inputValue = input<string>('');
  inputValueChange = output<string>()
  input = new FormControl();

  constructor(private cdr: ChangeDetectorRef) {
  }

  ngOnInit(): void {
    this.input.setValue(this.inputValue());
  }

  onValueChange(){
    this.inputValueChange.emit(this.input.value)
  }
}
