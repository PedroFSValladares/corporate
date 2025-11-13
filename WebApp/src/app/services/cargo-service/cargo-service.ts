import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {ApiResponse} from '../../model/ApiResponse';
import {HttpClient} from '@angular/common/http';
import {CargoResumido} from '../../model/CargoResumido';
import {environment} from '../../environment';

@Injectable({
  providedIn: 'root'
})
export class CargoService {

  constructor(private httpClient: HttpClient) { }

  obterCargos(): Observable<ApiResponse<CargoResumido[]>>{
    return this.httpClient.get<ApiResponse<CargoResumido[]>>(`${environment.apiUrl}/cargos`);
  }

  obterCargoPorId(id:number) : Observable<ApiResponse<CargoResumido>>{
    return this.httpClient.get<ApiResponse<CargoResumido>>(`${environment.apiUrl}/cargos/${id}`);
  }
}
