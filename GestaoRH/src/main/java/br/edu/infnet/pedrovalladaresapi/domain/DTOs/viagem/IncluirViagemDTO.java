package br.edu.infnet.pedrovalladaresapi.domain.DTOs.viagem;

import br.edu.infnet.pedrovalladaresapi.domain.enuns.TipoViagem;
import jakarta.validation.constraints.NotNull;

public class IncluirViagemDTO {
    @NotNull(message = "O transporte deve ser informado.")
    private String idTransporte;
    @NotNull(message = "O tipo da viagem deve ser informado.")
    private TipoViagem tipoViagem;

    public String getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(String idTransporte) {
        this.idTransporte = idTransporte;
    }

    public TipoViagem getTipoViagem() {
        return tipoViagem;
    }

    public void setTipoViagem(TipoViagem tipoViagem) {
        this.tipoViagem = tipoViagem;
    }
}
