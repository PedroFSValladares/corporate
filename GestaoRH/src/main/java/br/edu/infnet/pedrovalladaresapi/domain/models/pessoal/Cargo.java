package br.edu.infnet.pedrovalladaresapi.domain.models.pessoal;

import br.edu.infnet.pedrovalladaresapi.domain.DTOs.cargo.CargoResumidoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "cargos")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cargo_id")
    private int Id;
    @Column(name = "nome_cargo", nullable = false)
    private String Nome;
    @Column(name = "remuneracao", nullable = false)
    private Double Remuneracao;
    @Column(name = "v_vale_alimentacao", nullable = false)
    private Double ValeAlimentacao;
    @Column(name = "v_vale_transporte", nullable = false)
    private Double ValeTransporte;
    @Column(name = "adicional_periculosidade", nullable = false)
    private Boolean AdicionalDePericulosidade;
    @Column(name = "adcional_insalubridade", nullable = false)
    private Boolean AdicionalDeInsalubridade;
    @Column(name = "carga_horaria", nullable = false)
    private Integer CargaHoraria;
    @Column(name = "ativo", nullable = false)
    private Boolean Ativo;

    @Override
    public String toString(){
        return String.format("Cargo: %s | Id: %d | Carga Horária: %d | Remuneração: %.2f | Vale Alimentação: %.2f | Vale Transporte: %.2f | Periculosidade: %s | Insalubridade: %s",
                Nome, Id, CargaHoraria, Remuneracao, ValeAlimentacao, ValeTransporte,
                AdicionalDePericulosidade ? "Sim" : "Não", AdicionalDeInsalubridade ? "Sim" : "Não");
    }

    public CargoResumidoDTO toCargoResumidoDTO(){
        CargoResumidoDTO cargoResumidoDTO = new CargoResumidoDTO();

        cargoResumidoDTO.setId(this.Id);
        cargoResumidoDTO.setNome(this.Nome);

        return cargoResumidoDTO;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

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

    public Boolean getAtivo() {
        return Ativo;
    }

    public void setAtivo(Boolean ativo) {
        Ativo = ativo;
    }
}
