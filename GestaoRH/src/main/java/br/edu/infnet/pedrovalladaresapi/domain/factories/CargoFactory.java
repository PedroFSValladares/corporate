package br.edu.infnet.pedrovalladaresapi.domain.factories;

import br.edu.infnet.pedrovalladaresapi.domain.DTOs.cargo.IncluirCargoDTO;
import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Cargo;

public class CargoFactory {
    public static Cargo criarCargo(IncluirCargoDTO incluirCargoDTO){
        Cargo cargo = new Cargo();

        cargo.setNome(incluirCargoDTO.getNome());
        cargo.setRemuneracao(incluirCargoDTO.getRemuneracao());
        cargo.setValeTransporte(incluirCargoDTO.getValeTransporte());
        cargo.setValeAlimentacao(incluirCargoDTO.getValeAlimentacao());
        cargo.setAdicionalDeInsalubridade(incluirCargoDTO.getAdicionalDeInsalubridade());
        cargo.setAdicionalDePericulosidade(incluirCargoDTO.getAdicionalDePericulosidade());
        cargo.setAtivo(true);
        cargo.setCargaHoraria(incluirCargoDTO.getCargaHoraria());

        return cargo;
    }
}
