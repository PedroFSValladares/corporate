import {Directive, ElementRef, Input} from '@angular/core';

@Directive({
  selector: '[appInputId]'
})
export class InputId {

  constructor(private element: ElementRef) { }

  @Input() set appInputId(value:string) {
    this.element.nativeElement.querySelector("input").id = value
  }

}
