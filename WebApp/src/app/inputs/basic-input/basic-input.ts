import {Component, input, model, OnInit, output} from '@angular/core';
import {FormControl, FormsModule, ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-basic-input',
  imports: [
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './basic-input.html',
  styleUrl: './basic-input.css'
})
export class BasicInput implements OnInit {
  ngOnInit(): void {
      this.desabilitado() ? this.input.disable() : this.input.enable();
      this.input.setValue(this.inputValue());
  }
  desabilitado = input<boolean>(false);
  inputValue = input<string>('');

  inputValueChange = output<string>();
  input = new FormControl('');

  onValueChange(event:Event):void{
    this.inputValueChange.emit(this.input.value!)
  }

}
