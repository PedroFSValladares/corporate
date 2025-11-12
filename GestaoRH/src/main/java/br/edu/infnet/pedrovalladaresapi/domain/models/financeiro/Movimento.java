package br.edu.infnet.pedrovalladaresapi.domain.models.financeiro;

public class Movimento {
    private String nome;
    private Double valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
