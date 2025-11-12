package br.edu.infnet.pedrovalladaresapi.domain.DTOs.transporte;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AlterarTransporteDTO {
    @NotNull(message = "A tarifa deve ser informada.")
    @Positive(message = "A tarifa do transporte deve ser maior que 0.")
    private Double Tarifa;

    @NotEmpty(message = "O Itinirario do transporte deve ser informado.")
    private String itinerario;

    @NotEmpty(message = "O estado de origem do transporte deve ser informado.")
    private String estado;
    @NotNull(message = "O status deve ser informado.")
    private Boolean ativo;

    public Double getTarifa() {
        return Tarifa;
    }

    public void setTarifa(Double tarifa) {
        Tarifa = tarifa;
    }

    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(String itinerario) {
        this.itinerario = itinerario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
