package br.edu.infnet.pedrovalladaresapi.domain.factories;

import br.edu.infnet.pedrovalladaresapi.domain.enuns.TipoPonto;
import br.edu.infnet.pedrovalladaresapi.domain.models.frequencia.DiaUtil;
import br.edu.infnet.pedrovalladaresapi.domain.models.frequencia.FolhaDeFrequencia;
import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Funcionario;
import br.edu.infnet.pedrovalladaresapi.domain.models.frequencia.Ponto;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FolhaDeFrequenciaFactory {
    public static FolhaDeFrequencia gerarFolhaDeFrequencia(Funcionario funcionario, List<Ponto> pontos){
        FolhaDeFrequencia folhaDeFrequencia = new FolhaDeFrequencia();
        Map<LocalDate, DiaUtil> entradas = new HashMap<>();
        Map<LocalDate, DiaUtil> saidas = new HashMap<>();
        Duration horasTrabalhadas;

        pontos.forEach(ponto -> {

            DiaUtil diaUtil = new DiaUtil();
            diaUtil.setData(ponto.getData());

            if (ponto.getTipoPonto().equals(TipoPonto.Entrada)){
                diaUtil.setEntrada(ponto.getHorarioPonto());
                entradas.put(diaUtil.getData(), diaUtil);
            }

            if (ponto.getTipoPonto().equals(TipoPonto.Saida)){
                diaUtil.setSaida(ponto.getHorarioPonto());
                saidas.put(diaUtil.getData(), diaUtil);
            }
        });

        entradas.forEach((localDate, diaUtil) -> {
            var diaSaida = saidas.get(localDate);
            diaUtil.setSaida(diaSaida.getSaida());
        });

        var horariosDias = entradas.values().stream().map(dia -> Duration.between(dia.getSaida(), dia.getEntrada()));
        horasTrabalhadas = horariosDias.reduce(Duration.ZERO, (Duration::plus));

        folhaDeFrequencia.setDiasFrequentados(new ArrayList<>(entradas.values()));
        folhaDeFrequencia.setFuncionario(funcionario);
        folhaDeFrequencia.setHorasTrabalhadas(horasTrabalhadas);
        folhaDeFrequencia.setDiasUteis(22); //TODO lógica para obter dias uteis

        return folhaDeFrequencia;
    }
}
