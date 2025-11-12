package br.edu.infnet.pedrovalladaresapi.controllers;

import br.edu.infnet.pedrovalladaresapi.domain.DTOs.cargo.AlterarCargoDTO;
import br.edu.infnet.pedrovalladaresapi.domain.DTOs.cargo.IncluirCargoDTO;
import br.edu.infnet.pedrovalladaresapi.domain.factories.CargoFactory;
import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Cargo;
import br.edu.infnet.pedrovalladaresapi.services.CargoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.infnet.pedrovalladaresapi.requests.RequestResponse;

@RestController
@RequestMapping("/api/cargos")
public class CargoController {

    private final CargoService cargoService;

    public CargoController(CargoService cargoService){
        this.cargoService = cargoService;
    }

    @PostMapping
    public ResponseEntity<RequestResponse> incluir(@Valid @RequestBody IncluirCargoDTO incluirCargoDTO){
        Cargo cargo = CargoFactory.criarCargo(incluirCargoDTO);
        cargo = cargoService.incluir(cargo);

        return RequestResponse.getByCode(HttpStatus.CREATED, cargo);
    }

    @GetMapping
    public ResponseEntity<RequestResponse> listarTodos(){
        var cargos = cargoService.listarTodos();
        var cargosResumidos = cargos.stream().map(Cargo::toCargoResumidoDTO).toList();
        return cargos.isEmpty() ? RequestResponse.getByCode(HttpStatus.NO_CONTENT, null) : RequestResponse.getByCode(HttpStatus.OK, cargosResumidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestResponse> obterPorId(@PathVariable Integer id){
        Cargo cargo = cargoService.obterPorId(id);
        return cargo == null ? RequestResponse.getByCode(HttpStatus.NOT_FOUND, null) : RequestResponse.getByCode(HttpStatus.OK ,cargo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequestResponse> alterar(@PathVariable Integer id, @Valid @RequestBody AlterarCargoDTO alterarCargoDTO){
        Cargo cargo = cargoService.obterPorId(id);

        if(cargo == null)
            return RequestResponse.getByCode(HttpStatus.NOT_FOUND, null);
        else{
            cargo.setNome(alterarCargoDTO.getNome());
            cargo.setRemuneracao(alterarCargoDTO.getRemuneracao());
            cargo.setValeTransporte(alterarCargoDTO.getValeTransporte());
            cargo.setValeAlimentacao(alterarCargoDTO.getValeAlimentacao());
            cargo.setAdicionalDeInsalubridade(alterarCargoDTO.getAdicionalDeInsalubridade());
            cargo.setAdicionalDePericulosidade(alterarCargoDTO.getAdicionalDePericulosidade());
            cargo.setCargaHoraria(alterarCargoDTO.getCargaHoraria());

            cargo = cargoService.alterar(id, cargo);
            return RequestResponse.getByCode(HttpStatus.OK, cargo);
        }
    }

    @PatchMapping("/inativar/{id}")
    public ResponseEntity<RequestResponse> inativar(@PathVariable Integer id){
        Cargo cargo = cargoService.obterPorId(id);
        if(cargo == null)
             return RequestResponse.getByCode(HttpStatus.NOT_FOUND, null);
        else{
            cargoService.inativar(id);
            return RequestResponse.getByCode(HttpStatus.NO_CONTENT, null);
        }
    }
}
