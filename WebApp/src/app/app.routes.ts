import { Routes } from '@angular/router';
import {ListarFuncionarioComponent} from './funcionarios/listar-funcionario-component/listar-funcionario-component';
import {IncluirFuncionarioComponent} from './funcionarios/incluir-funcionario-component/incluir-funcionario-component';
import {AlterarFuncionarioComponent} from './funcionarios/alterar-funcionario-component/alterar-funcionario-component';
import {
  DetalharFuncionarioComponent
} from './funcionarios/detalhar-funcionario-component/detalhar-funcionario-component';

export const routes: Routes = [
    {path: 'funcionarios',
        children: [
            {path: '', component: ListarFuncionarioComponent},
            {path: 'inlcuir', component: IncluirFuncionarioComponent},
            {path: 'detalhar/:cpf', component: DetalharFuncionarioComponent},
            {path: 'alterar/:cpf', component: AlterarFuncionarioComponent}
        ]
    }
];
