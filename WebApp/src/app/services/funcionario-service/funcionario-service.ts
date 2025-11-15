import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FuncionarioResumido} from '../../model/FuncionarioResumido';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import {ApiResponse} from '../../model/ApiResponse';
import {FuncionarioCompleto} from '../../model/FuncionarioCompleto';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {
  constructor(private httpClient: HttpClient) { }

  obterTodosOsFuncionarios() : Observable<ApiResponse<FuncionarioResumido[]>>{
    return this.httpClient.get<ApiResponse<FuncionarioResumido[]>>(`${environment.apiUrl}/funcionarios`);
  }

  obterFuncionarioPorCpf(cpf : string) : Observable<ApiResponse<FuncionarioCompleto>>{
    let funcionario:FuncionarioCompleto = new FuncionarioCompleto();

    return this.httpClient.get<ApiResponse<FuncionarioCompleto>>(`${environment.apiUrl}/funcionarios/${cpf}`)
  }
}
