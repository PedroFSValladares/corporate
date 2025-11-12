package br.edu.infnet.pedrovalladaresapi.domain.DTOs.calculo;

import br.edu.infnet.pedrovalladaresapi.domain.enuns.TipoCalculo;
import br.edu.infnet.pedrovalladaresapi.domain.models.math.Calculo;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AlterarCalculoDTO {
    @NotEmpty(message = "O nome do calculo deve ser informado.")
    private String nome;
    @NotEmpty(message = "O calculo deve ser informado.")
    private String calculo;
    @NotNull(message = "Deve ser informado se o calculo é aplicavel a todas as folhas.")
    private boolean aplicavelEmTodos;
    @NotNull(message = "O tipo de calculo deve ser informado.")
    @Column(name = "tipo_calculo", nullable = false)
    private TipoCalculo tipoCalculo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCalculo() {
        return calculo;
    }

    public void setCalculo(String calculo) {
        this.calculo = calculo;
    }

    public boolean isAplicavelEmTodos() {
        return aplicavelEmTodos;
    }

    public void setAplicavelEmTodos(boolean aplicavelEmTodos) {
        this.aplicavelEmTodos = aplicavelEmTodos;
    }

    public TipoCalculo getTipoCalculo() {
        return tipoCalculo;
    }

    public void setTipoCalculo(TipoCalculo tipoCalculo) {
        this.tipoCalculo = tipoCalculo;
    }

    public Calculo toEntity(){
        Calculo calculo = new Calculo();

        calculo.setNome(nome);
        calculo.setCalculo(this.calculo);
        calculo.setAplicavelEmTodos(aplicavelEmTodos);
        calculo.setTipoCalculo(tipoCalculo);

        return calculo;
    }
}
