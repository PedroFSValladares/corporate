export class FuncionarioResumido {
  cpf: string;
  matricula: string;
  nome: string
  nomeCargo: string
  status: boolean

    constructor(cpf: string, nome: string, matricula: string, nomeCargo: string, status: boolean) {
        this.cpf = cpf;
        this.nome = nome;
        this.matricula = matricula;
        this.nomeCargo = nomeCargo;
        this.status = status;
    }
}
