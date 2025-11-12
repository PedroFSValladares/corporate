package br.edu.infnet.pedrovalladaresapi.domain.factories;

import br.edu.infnet.pedrovalladaresapi.domain.DTOs.funcionario.IncluirFuncionarioDTO;
import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Cargo;
import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Funcionario;

public class FuncionarioFactory {
    public static Funcionario criarFuncionario(IncluirFuncionarioDTO funcionarioDTO){
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCpf(funcionarioDTO.getCPF());
        funcionario.setAtivo(true);
        funcionario.setEmail(funcionarioDTO.getEmail());
        funcionario.setTelefone(funcionarioDTO.getTelefone());
        funcionario.setMatricula(funcionario.gerarMatricula());
        funcionario.setEndereco(funcionarioDTO.getEndereco());
        funcionario.setViagens(funcionarioDTO.getViagens());

        Cargo cargo = new Cargo();
        cargo.setId(funcionarioDTO.getCargoId());
        funcionario.setCargo(cargo);

        return funcionario;
    }
}
