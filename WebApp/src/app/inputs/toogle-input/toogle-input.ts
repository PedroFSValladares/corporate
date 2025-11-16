import {Component, EventEmitter, input, OnInit, output} from '@angular/core';
import {BasicInput} from '../basic-input/basic-input';
import {NgStyle} from '@angular/common';

@Component({
  selector: 'app-toogle-input',
  imports: [
    NgStyle
  ],
  templateUrl: './toogle-input.html',
  styleUrl: './toogle-input.css'
})
export class ToogleInput implements OnInit {
  booleanValue : boolean = false;
  trueColor : string = 'darkseagreen';
  falseColor : string = 'indianred';
  desabilitado = input<boolean>(false);
  inputValue = input<boolean>(true);
  inputValueChange = output<boolean>();

  ngOnInit(): void {
    if(this.inputValue != undefined){
      this.booleanValue = true;
    }else{
      console.error({
        'object': this,
        'error': 'status recebido era igual a undefined'
      })
    }
  }
  toogle(event: Event) {
    event.preventDefault();
    if(!this.desabilitado()){
      this.booleanValue = !this.booleanValue;
      this.inputValueChange.emit(this.booleanValue);
    }
  }


}
