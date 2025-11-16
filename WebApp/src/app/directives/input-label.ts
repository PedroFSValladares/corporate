import {Directive, ElementRef, Input} from '@angular/core';

@Directive({
  selector: '[appInputLabel]'
})
export class InputLabel {

  constructor(private element: ElementRef) { }

  @Input() set appInputLabel(value:string) {
    this.element.nativeElement.querySelector("label").innerText = value;
  }
}
