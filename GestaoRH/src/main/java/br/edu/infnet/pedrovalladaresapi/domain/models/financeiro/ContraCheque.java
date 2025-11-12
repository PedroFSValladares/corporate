package br.edu.infnet.pedrovalladaresapi.domain.models.financeiro;

import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Funcionario;

import java.util.List;

public class ContraCheque {
    private Funcionario funcionario;
    private Double remuneracaoBruta;
    private Double getRemuneracaoLiquida;
    private List<Movimento> beneficios;
    private List<Movimento> deducoes;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Double getRemuneracaoBruta() {
        return remuneracaoBruta;
    }

    public void setRemuneracaoBruta(Double remuneracaoBruta) {
        this.remuneracaoBruta = remuneracaoBruta;
    }

    public Double getGetRemuneracaoLiquida() {
        return getRemuneracaoLiquida;
    }

    public void setGetRemuneracaoLiquida(Double getRemuneracaoLiquida) {
        this.getRemuneracaoLiquida = getRemuneracaoLiquida;
    }

    public List<Movimento> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<Movimento> beneficios) {
        this.beneficios = beneficios;
    }

    public List<Movimento> getDeducoes() {
        return deducoes;
    }

    public void setDeducoes(List<Movimento> deducoes) {
        this.deducoes = deducoes;
    }
}
