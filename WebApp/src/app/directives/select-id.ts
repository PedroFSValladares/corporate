import {Directive, ElementRef, Input} from '@angular/core';

@Directive({
  selector: '[appSelectId]'
})
export class SelectId {

  constructor(private element: ElementRef) { }

  @Input() set appSelectId(value: string) {
    this.element.nativeElement.querySelector("select").id = value;
  }

}
