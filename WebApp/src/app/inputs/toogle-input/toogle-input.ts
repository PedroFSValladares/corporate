import {Component, OnInit} from '@angular/core';
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
export class ToogleInput extends BasicInput<boolean> implements OnInit {
  ngOnInit(): void {
    if(this.inputValue != undefined){
      this.booleanValue = this.inputValue()!;
    }else{
      console.error({
        'object': this,
        'error': 'status recebido era igual a undefined'
      })
    }
  }
  booleanValue : boolean = false;
  trueColor : string = 'darkseagreen';
  falseColor : string = 'indianred';
  toogle(event: Event) {
    event.preventDefault();
    if(!this.desabilitado())
      this.booleanValue = !this.booleanValue;
  }


}
