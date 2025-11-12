package br.edu.infnet.pedrovalladaresapi.domain.models.frequencia;

import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Funcionario;

import java.time.Duration;
import java.util.List;

public class FolhaDeFrequencia {
    private Funcionario funcionario;
    private List<DiaUtil> diasFrequentados;
    private Duration horasTrabalhadas;
    private int diasUteis;
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<DiaUtil> getDiasFrequentados() {
        return diasFrequentados;
    }

    public void setDiasFrequentados(List<DiaUtil> diasFrequentados) {
        this.diasFrequentados = diasFrequentados;
    }

    public Duration getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Duration horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public int getDiasUteis() {
        return diasUteis;
    }

    public void setDiasUteis(int diasUteis) {
        this.diasUteis = diasUteis;
    }
}
