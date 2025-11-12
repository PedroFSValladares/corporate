package br.edu.infnet.pedrovalladaresapi.domain.models.math;

import br.edu.infnet.pedrovalladaresapi.domain.enuns.TipoCalculo;
import jakarta.persistence.*;

@Entity
@Table(name = "calculos")
public class Calculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "calculo", nullable = false)
    private String calculo;
    @Column(name = "aplicavel_em_todos", nullable = false)
    private boolean aplicavelEmTodos;
    @Column(name = "tipo_calculo", nullable = false)
    private TipoCalculo tipoCalculo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
