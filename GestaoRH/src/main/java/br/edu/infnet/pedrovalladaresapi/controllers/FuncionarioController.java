package br.edu.infnet.pedrovalladaresapi.controllers;

import br.edu.infnet.pedrovalladaresapi.clients.ViaCepFeignClient;
import br.edu.infnet.pedrovalladaresapi.domain.DTOs.funcionario.AlterarFuncionarioDTO;
import br.edu.infnet.pedrovalladaresapi.domain.DTOs.funcionario.IncluirFuncionarioDTO;
import br.edu.infnet.pedrovalladaresapi.domain.factories.FuncionarioFactory;
import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Endereco;
import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Funcionario;
import br.edu.infnet.pedrovalladaresapi.requests.RequestResponse;
import br.edu.infnet.pedrovalladaresapi.services.FuncionariosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionariosService funcionariosService;
    private final ViaCepFeignClient viaCepFeignClient;

    public FuncionarioController(FuncionariosService funcionariosService, ViaCepFeignClient viaCepFeignClient){
        this.funcionariosService = funcionariosService;
        this.viaCepFeignClient = viaCepFeignClient;
    }

    @PostMapping
    public ResponseEntity<RequestResponse> incluir(@Valid @RequestBody IncluirFuncionarioDTO funcionario){
        if(funcionariosService.obterPorId(funcionario.getCPF()) != null)
            return RequestResponse.getByCode(HttpStatus.CONFLICT, "Já existe um funcionário com este CPF.");

        Funcionario funcionarioAIncluir = FuncionarioFactory.criarFuncionario(funcionario);

        var novoFuncionario = funcionariosService.incluir(funcionarioAIncluir);

        return RequestResponse.getByCode(HttpStatus.CREATED, novoFuncionario);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<RequestResponse> obterPorId(@PathVariable String cpf){
        var funcionario = funcionariosService.obterPorId(cpf);
        return funcionario == null ? RequestResponse.getByCode(HttpStatus.NOT_FOUND, null) : RequestResponse.getByCode(HttpStatus.OK, funcionario);
    }

    @GetMapping
    public ResponseEntity<RequestResponse> obterTodos(){
        var funcionarios = funcionariosService.listarTodos();
        var funcionarioResumidoDTOS = funcionarios.stream().map(Funcionario::toFuncionarioResumidoDTO).toList();
        return funcionarios.isEmpty() ? RequestResponse.getByCode(HttpStatus.NO_CONTENT, null) : RequestResponse.getByCode(HttpStatus.OK, funcionarioResumidoDTOS);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<RequestResponse> alterar(@PathVariable String cpf, @Valid @RequestBody AlterarFuncionarioDTO funcionarioParaAtualizar){
        var funcionario = funcionariosService.obterPorId(cpf);
        if(funcionario == null)
            return RequestResponse.getByCode(HttpStatus.NOT_FOUND, null);
        else{
            funcionario.setNome(funcionarioParaAtualizar.getNome());
            funcionario.setTelefone(funcionarioParaAtualizar.getTelefone());
            funcionario.setEmail(funcionarioParaAtualizar.getEmail());
            funcionario.setAtivo(funcionarioParaAtualizar.getAtivo());
            funcionario.setEndereco(funcionarioParaAtualizar.getEndereco());
            funcionario.setViagens(funcionarioParaAtualizar.getViagens());

            var funcionarioAtualizado = funcionariosService.alterar(cpf, funcionario);
            return RequestResponse.getByCode(HttpStatus.OK, funcionarioAtualizado);
        }
    }

    @PatchMapping("/inativar/{cpf}")
    public ResponseEntity<RequestResponse> inativar(@PathVariable String cpf){
        var funcionario = funcionariosService.obterPorId(cpf);
        if(funcionario == null)
            return RequestResponse.getByCode(HttpStatus.NOT_FOUND, null);
        else {
            funcionariosService.inativar(cpf);
            return RequestResponse.getByCode(HttpStatus.NO_CONTENT, null);
        }
    }

    @GetMapping("/endereco/{cep}")
    public ResponseEntity<RequestResponse> obterEnderecoPeloCep(@PathVariable String cep){
        Endereco endereco = viaCepFeignClient.findByCep(cep);
        return endereco.getCEP() == null ? RequestResponse.getByCode(HttpStatus.NOT_FOUND, null) : RequestResponse.getByCode(HttpStatus.OK, endereco);
    }
}
