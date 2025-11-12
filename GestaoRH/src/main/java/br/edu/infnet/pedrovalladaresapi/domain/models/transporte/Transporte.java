package br.edu.infnet.pedrovalladaresapi.domain.models.transporte;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "transportes")
public class Transporte {
    @Id
    @Column(name = "codigo_linha")
    @NotEmpty(message = "O código da linha deve ser informado.")
    private String codigo;
    @Column(name = "tarifa")
    @NotNull(message = "A tarifa deve ser informada.")
    @Positive(message = "A tarifa do transporte deve ser maior que 0.")
    private Double Tarifa;
    @Column(name = "itinerario")
    @NotEmpty(message = "O Itinirario do transporte deve ser informado.")
    private String itinerario;
    @Column(name = "estado", length = 2)
    @NotEmpty(message = "O estado de origem do transporte deve ser informado")
    private String estado;
    @Column(name = "ativo")
    private Boolean ativo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getTarifa() {
        return Tarifa;
    }

    public void setTarifa(Double tarifa) {
        Tarifa = tarifa;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
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
}
