import {Directive, ElementRef, Input} from '@angular/core';

@Directive({
  selector: '[appSelectName]'
})
export class SelectName {

  constructor(private element: ElementRef) { }

  @Input() set appSelectName(value:string) {
    this.element.nativeElement.querySelector("select").name = value;
  }
}
