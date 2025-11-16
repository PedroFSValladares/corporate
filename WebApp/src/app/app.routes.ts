import { Routes } from '@angular/router';
import {ListarFuncionarioComponent} from './pages/funcionarios/listar-funcionario-component/listar-funcionario-component';
import {IncluirFuncionarioComponent} from './pages/funcionarios/incluir-funcionario-component/incluir-funcionario-component';
import {AlterarFuncionarioComponent} from './pages/funcionarios/alterar-funcionario-component/alterar-funcionario-component';
import {
  DetalharFuncionarioComponent
} from './pages/funcionarios/detalhar-funcionario-component/detalhar-funcionario-component';
import {Home} from './pages/home/home';
import {NotFound} from './pages/not-found/not-found';

export const routes: Routes = [
  {
    path: '', component: Home
  },
  {
    path: 'funcionarios',
      children: [
          {path: '', component: ListarFuncionarioComponent},
          {path: 'incluir', component: IncluirFuncionarioComponent},
          {path: 'detalhar/:cpf', component: DetalharFuncionarioComponent},
          {path: 'alterar/:cpf', component: AlterarFuncionarioComponent}
      ]
  },
  {
    path: '**', component: NotFound
  }
];
