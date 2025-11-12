import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FuncionarioResumido} from '../../model/FuncionarioResumido';
import {environment} from '../../environment';
import {Observable} from 'rxjs';
import {ApiResponse} from '../../model/ApiResponse';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {
  constructor(private httpClient: HttpClient) { }

  obterTodosOsFuncionarios() : Observable<ApiResponse<FuncionarioResumido>>{
    return this.httpClient.get<ApiResponse<FuncionarioResumido>>(environment.apiUrl+"/funcionarios");
  }
}
