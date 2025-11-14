package br.edu.infnet.pedrovalladaresapi.loaders;

import br.edu.infnet.pedrovalladaresapi.domain.enuns.TipoPonto;
import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Funcionario;
import br.edu.infnet.pedrovalladaresapi.domain.models.frequencia.Ponto;
import br.edu.infnet.pedrovalladaresapi.services.FolhaDeFrequenciaService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Order(3)
@Component
public class PontoLoader extends BaseLoader {

    private final FolhaDeFrequenciaService folhaDeFrequenciaService;

    public PontoLoader(FolhaDeFrequenciaService folhaDeFrequenciaService){
        this.folhaDeFrequenciaService = folhaDeFrequenciaService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[] campos;
        var linhas = obterLinhasDeArquivo("Dados/Pontos.tsv", true);

        for(String linha : linhas){
            campos = linha.split("\t");

            Ponto ponto = new Ponto();

            Funcionario funcionario = new Funcionario();
            funcionario.setCpf(campos[0]);
            ponto.setFuncionario(funcionario);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ponto.setData(LocalDate.parse(campos[1], formatter).minusMonths(2)); // subtraindo 2 meses pois o Gemini colocou as datas no futuro indevidamente

            ponto.setHorarioPonto(LocalTime.parse(campos[2]));

            TipoPonto tipoPonto = campos[3].equals("ENTRADA") ? TipoPonto.Entrada : TipoPonto.Saida;
            ponto.setTipoPonto(tipoPonto);

            folhaDeFrequenciaService.incluir(ponto);
        }
    }
}
