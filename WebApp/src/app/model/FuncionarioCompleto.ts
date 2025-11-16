import {Endereco} from './Endereco';
import {Viagem} from './Viagem';

export class FuncionarioCompleto{
  nome : string = "";
  cpf : string = "";
  telefone: string = "";
  email : string = "";
  cargoId: string = '';
  matricula : string = "";
  ativo : boolean = false;
  endereco : Endereco = new Endereco();
  viagens: Viagem[] = []
}
