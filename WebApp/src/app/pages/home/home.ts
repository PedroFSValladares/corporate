import { Component } from '@angular/core';
import {Division} from '../../layouts/division/division';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [
    Division,
    RouterLink
  ],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {

}
