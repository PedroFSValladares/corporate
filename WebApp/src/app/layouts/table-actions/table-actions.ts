import {Component, input} from '@angular/core';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-table-actions',
  imports: [
    RouterLink
  ],
  templateUrl: './table-actions.html',
  styleUrl: './table-actions.css'
})
export class TableActions {
  entityId = input<string>();
}
