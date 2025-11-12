package br.edu.infnet.pedrovalladaresapi.domain.models.math;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "variaveis")
public class Variavel {
    @Id
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "descricao", nullable = false)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
