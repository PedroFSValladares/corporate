package br.edu.infnet.pedrovalladaresapi.domain.DTOs.cargo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class AlterarCargoDTO {
    @NotEmpty(message = "O Campo nome deve ser informado.")
    private String Nome;
    @NotNull(message = "O campo Remuneração deve ser informado.")
    @Positive(message = "A remuneração deve ser maior que 0.")
    private Double Remuneracao;
    @NotNull(message = "O campo Vale alimentação deve ser informado.")
    @PositiveOrZero(message = "O vale alimentação não pode ser negativo.")
    private Double ValeAlimentacao;
    @NotNull(message = "O campo Vale transporte deve ser informado.")
    @PositiveOrZero(message = "O vale transporte não pode ser negativo.")
    private Double ValeTransporte;
    @NotNull(message = "O campo adicional de periculosidade deve ser informado.")
    private Boolean AdicionalDePericulosidade;
    @NotNull(message = "O campo adicional de insalubridade deve ser informado.")
    private Boolean AdicionalDeInsalubridade;
    @NotNull(message = "O campo carga horária deve ser informado.")
    @Positive(message = "A carga horária deve ser maior que 0.")
    private Integer CargaHoraria;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Double getRemuneracao() {
        return Remuneracao;
    }

    public void setRemuneracao(Double remuneracao) {
        Remuneracao = remuneracao;
    }

    public Double getValeAlimentacao() {
        return ValeAlimentacao;
    }

    public void setValeAlimentacao(Double valeAlimentacao) {
        ValeAlimentacao = valeAlimentacao;
    }

    public Double getValeTransporte() {
        return ValeTransporte;
    }

    public void setValeTransporte(Double valeTransporte) {
        ValeTransporte = valeTransporte;
    }

    public Boolean getAdicionalDePericulosidade() {
        return AdicionalDePericulosidade;
    }

    public void setAdicionalDePericulosidade(Boolean adicionalDePericulosidade) {
        AdicionalDePericulosidade = adicionalDePericulosidade;
    }

    public Boolean getAdicionalDeInsalubridade() {
        return AdicionalDeInsalubridade;
    }

    public void setAdicionalDeInsalubridade(Boolean adicionalDeInsalubridade) {
        AdicionalDeInsalubridade = adicionalDeInsalubridade;
    }

    public Integer getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        CargaHoraria = cargaHoraria;
    }
}
