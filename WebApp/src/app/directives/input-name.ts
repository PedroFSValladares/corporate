import {Directive, ElementRef, Input} from '@angular/core';

@Directive({
  selector: '[appInputName]'
})
export class InputName {

  constructor(private element: ElementRef) { }

  @Input() set appInputName(value: string) {
    this.element.nativeElement.querySelector("label").setAttribute("for", value);
    this.element.nativeElement.querySelector("input").name = value;
  }

}
