package br.edu.infnet.pedrovalladaresapi.controllers;

import br.edu.infnet.pedrovalladaresapi.domain.DTOs.transporte.AlterarTransporteDTO;
import br.edu.infnet.pedrovalladaresapi.domain.models.transporte.Transporte;
import br.edu.infnet.pedrovalladaresapi.requests.RequestResponse;
import br.edu.infnet.pedrovalladaresapi.services.TransporteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transporte")
public class TransporteController {

    private final TransporteService transporteService;

    public TransporteController(TransporteService transporteService){
        this.transporteService = transporteService;
    }

    @PostMapping
    public ResponseEntity<RequestResponse> incluir(@Valid @RequestBody Transporte transporte){
        Transporte transporteCriado = transporteService.incluir(transporte);
        return RequestResponse.getByCode(HttpStatus.CREATED, transporteCriado);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<RequestResponse> obterPorCodigo(@PathVariable String codigo){
        Transporte transporte = transporteService.obterPorId(codigo);
        return transporte == null ? RequestResponse.getByCode(HttpStatus.NOT_FOUND, null) : RequestResponse.getByCode(HttpStatus.OK, transporte);
    }

    @GetMapping
    public ResponseEntity<RequestResponse> obterTodos(){
        var transportes = transporteService.listarTodos();
        return transportes.isEmpty() ? RequestResponse.getByCode(HttpStatus.NO_CONTENT, null) : RequestResponse.getByCode(HttpStatus.OK, transportes);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<RequestResponse> alterar(@PathVariable String codigo, @Valid @RequestBody AlterarTransporteDTO alterarTransporteDTO){
        Transporte transporteAlterado = new Transporte();
        transporteAlterado.setCodigo(codigo);
        transporteAlterado.setItinerario(alterarTransporteDTO.getItinerario());
        transporteAlterado.setTarifa(alterarTransporteDTO.getTarifa());
        transporteAlterado.setEstado(alterarTransporteDTO.getEstado());
        transporteAlterado.setAtivo(alterarTransporteDTO.getAtivo());

        transporteAlterado = transporteService.alterar(codigo, transporteAlterado);

        return transporteAlterado == null ? RequestResponse.getByCode(HttpStatus.NOT_FOUND, transporteAlterado) : RequestResponse.getByCode(HttpStatus.OK, transporteAlterado);
    }

    @PatchMapping("/inativar/{codigo}")
    public ResponseEntity<RequestResponse> inativar(@PathVariable String codigo){
        Transporte transporte = transporteService.obterPorId(codigo);

        if(transporte == null)
            return RequestResponse.getByCode(HttpStatus.NOT_FOUND, null);

        transporte.setAtivo(false);
        return RequestResponse.getByCode(HttpStatus.OK, transporteService.alterar(codigo, transporte));
    }
}
