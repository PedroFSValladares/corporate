package br.edu.infnet.pedrovalladaresapi.domain.factories;

import br.edu.infnet.pedrovalladaresapi.domain.models.financeiro.ContraCheque;
import br.edu.infnet.pedrovalladaresapi.domain.models.financeiro.Movimento;
import br.edu.infnet.pedrovalladaresapi.domain.models.frequencia.FolhaDeFrequencia;
import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class ContraChequeFactory {
    public static ContraCheque gerarContraCheque(Funcionario funcionario, FolhaDeFrequencia frequencia){
        ContraCheque contraCheque = new ContraCheque();
        int diasTrabalhados = frequencia.getDiasFrequentados().size();
        double valorRemuneracaoPorDia = funcionario.getCargo().getRemuneracao() / 22;
        double remuneracaoAPagar = valorRemuneracaoPorDia * diasTrabalhados;

        contraCheque.setFuncionario(funcionario);

        List<Movimento> beneficio = new ArrayList<>();
        Movimento remuneracaoBase = new Movimento();

        remuneracaoBase.setNome("Remuneração");
        remuneracaoBase.setValor(remuneracaoAPagar);

        beneficio.add(remuneracaoBase);

        contraCheque.setBeneficios(beneficio);

        return contraCheque;
    }
}
