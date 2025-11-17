import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { ApiResponse } from "../../model/ApiResponse";
import { Transporte } from "../../model/Transporte";
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TransporteService {
  constructor(private http: HttpClient) { }

  obterTodos(): Observable<ApiResponse<Transporte[]>>{
    return this.http.get<ApiResponse<Transporte[]>>(`${environment.apiUrl}/transporte`);
  }
}
