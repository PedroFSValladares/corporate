import {ChangeDetectorRef, Component, input} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-basic-input',
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './basic-input.html',
  styleUrl: './basic-input.css'
})
export class BasicInput{
  inputName = input<string>();
  inputId = input<string>();
  label = input<string>("Label");
  type = input<string>("text");

  constructor(private cdr: ChangeDetectorRef) {


  }

}
