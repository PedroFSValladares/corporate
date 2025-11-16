import {Directive, ElementRef, Input} from '@angular/core';

@Directive({
  selector: '[appInputType]'
})
export class InputType {

  constructor(private element: ElementRef) { }

  @Input() set appInputType(value:string) {
    this.element.nativeElement.querySelector("input").type = value;
  }
}
