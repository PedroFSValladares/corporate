package br.edu.infnet.pedrovalladaresapi.controllers;

import br.edu.infnet.pedrovalladaresapi.domain.DTOs.calculo.AlterarCalculoDTO;
import br.edu.infnet.pedrovalladaresapi.domain.DTOs.calculo.IncluirCalculoDTO;
import br.edu.infnet.pedrovalladaresapi.domain.models.math.Calculo;
import br.edu.infnet.pedrovalladaresapi.requests.RequestResponse;
import br.edu.infnet.pedrovalladaresapi.services.CalculoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculo")
public class CalculoController {

    private final CalculoService calculoService;

    public CalculoController(CalculoService calculoService){
        this.calculoService = calculoService;
    }

    @PostMapping
    public ResponseEntity<RequestResponse> incluir(@Valid @RequestBody IncluirCalculoDTO incluirCalculoDTO){
        Calculo calculo = calculoService.incluir(incluirCalculoDTO.toEntity());
        return RequestResponse.getByCode(HttpStatus.CREATED, calculo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestResponse> obterPorId(@PathVariable int id){
        Calculo calculo = calculoService.obterPorId(id);
        if(calculo == null)
            return RequestResponse.getByCode(HttpStatus.NOT_FOUND, null);
        return RequestResponse.getByCode(HttpStatus.OK, calculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequestResponse> alterar (@PathVariable int id, @Valid @RequestBody AlterarCalculoDTO alterarCalculoDTO){
        Calculo calculo = calculoService.obterPorId(id);
        if(calculo == null)
            return RequestResponse.getByCode(HttpStatus.NOT_FOUND, null);
        Calculo calculoAlterado = alterarCalculoDTO.toEntity();
        calculoAlterado.setId(calculo.getId());
        return RequestResponse.getByCode(HttpStatus.OK, calculoAlterado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RequestResponse> deletar(@PathVariable int id){
        calculoService.deletar(id);
        return RequestResponse.getByCode(HttpStatus.NO_CONTENT, null);
    }
}
