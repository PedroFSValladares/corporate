import {Component, input} from '@angular/core';

@Component({
  selector: 'app-division',
  imports: [],
  templateUrl: './division.html',
  styleUrl: './division.css'
})
export class Division {
  titulo = input<string>('');
}
