package br.edu.infnet.pedrovalladaresapi.controllers;

import br.edu.infnet.pedrovalladaresapi.domain.factories.FolhaDeFrequenciaFactory;
import br.edu.infnet.pedrovalladaresapi.domain.models.frequencia.FolhaDeFrequencia;
import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Funcionario;
import br.edu.infnet.pedrovalladaresapi.domain.models.frequencia.Ponto;
import br.edu.infnet.pedrovalladaresapi.requests.RequestResponse;
import br.edu.infnet.pedrovalladaresapi.services.FolhaDeFrequenciaService;
import br.edu.infnet.pedrovalladaresapi.services.FuncionariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/folhaDeFrequencia")
public class FolhaDeFrequenciaController {

    private final FolhaDeFrequenciaService folhaDeFrequenciaService;
    private final FuncionariosService funcionariosService;

    public FolhaDeFrequenciaController(FolhaDeFrequenciaService folhaDeFrequenciaService, FuncionariosService funcionariosService){
        this.folhaDeFrequenciaService = folhaDeFrequenciaService;
        this.funcionariosService = funcionariosService;
    }

    @PostMapping("/resgistrarPonto/{cpf}")
    public ResponseEntity<RequestResponse> baterPonto(@PathVariable String cpf){
        Funcionario funcionario = funcionariosService.obterPorId(cpf);
        Ponto ponto = funcionario.criarPonto();
        ponto = folhaDeFrequenciaService.incluir(ponto);

        return ponto == null ? RequestResponse.getByCode(HttpStatus.BAD_REQUEST, "Não é possível registrar nenhuma entrada ou saída mais.") : RequestResponse.getByCode(HttpStatus.CREATED, ponto);
    }

    @GetMapping("/{cpf}/{mes}")
    public ResponseEntity<RequestResponse> obterFolhaDeFuncionarioPorMes(@PathVariable String cpf, @PathVariable int mes){
        RequestResponse requestResponse;
        Funcionario funcionario = funcionariosService.obterPorId(cpf);
        var pontos = folhaDeFrequenciaService.obterPorMesEFuncionario(mes, cpf);

        if(funcionario == null)
            return RequestResponse.getByCode(HttpStatus.NOT_FOUND, null);
        else{
            FolhaDeFrequencia folhaDeFrequencia = FolhaDeFrequenciaFactory.gerarFolhaDeFrequencia(funcionario, pontos);
            return RequestResponse.getByCode(HttpStatus.OK, folhaDeFrequencia);
        }
    }
}
