package br.edu.infnet.pedrovalladaresapi.services;

import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Funcionario;
import br.edu.infnet.pedrovalladaresapi.domain.models.transporte.Viagem;
import br.edu.infnet.pedrovalladaresapi.domain.repositories.IEnderecoRespository;
import br.edu.infnet.pedrovalladaresapi.domain.repositories.IFuncionarioRepository;
import br.edu.infnet.pedrovalladaresapi.domain.repositories.IViagemRepository;
import br.edu.infnet.pedrovalladaresapi.interfaces.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionariosService implements
        IIncludableService<Funcionario>, IUpdatabelService<Funcionario, String>, IListableService<Funcionario>, IIdQueryableService<Funcionario, String>, IInativableService<String> {
    private final IFuncionarioRepository funcionarioRepository;
    private final IEnderecoRespository enderecoRespository;
    private final IViagemRepository viagemRepository;

    public FuncionariosService(IFuncionarioRepository funcionarioRepository, IEnderecoRespository enderecoRespository, IViagemRepository viagemRepository){
        this.funcionarioRepository = funcionarioRepository;
        this.enderecoRespository = enderecoRespository;
        this.viagemRepository = viagemRepository;
    }

    @Override
    public Funcionario incluir(Funcionario funcionario) {
        var endereco = enderecoRespository.findById(funcionario.getEndereco().getCEP());
        if(endereco.isEmpty())
            enderecoRespository.save(funcionario.getEndereco());
        if(funcionario.getViagens() != null)
            viagemRepository.saveAll(funcionario.getViagens());
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario alterar(String id, Funcionario funcionario) {
        if(!funcionarioRepository.existsById(id))
            return null;

        viagemRepository.saveAll(funcionario.getViagens());
        enderecoRespository.save(funcionario.getEndereco());

        return funcionarioRepository.save(funcionario);
    }

    @Override
    public void inativar(String CPF){
        Funcionario funcionario = obterPorId(CPF);
        if(funcionario != null){
            funcionario.setAtivo(false);
            funcionarioRepository.save(funcionario);
        }
    }

    @Override
    public Funcionario obterPorId(String CPF){
        var funcionario = funcionarioRepository.findById(CPF);
        return funcionario.orElse(null);
    }
}
