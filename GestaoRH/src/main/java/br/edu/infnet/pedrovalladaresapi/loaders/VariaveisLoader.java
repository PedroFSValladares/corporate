package br.edu.infnet.pedrovalladaresapi.loaders;

import br.edu.infnet.pedrovalladaresapi.domain.models.math.Variavel;
import br.edu.infnet.pedrovalladaresapi.services.VariavelService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VariaveisLoader extends BaseLoader{

    private final VariavelService variavelService;

    public VariaveisLoader(VariavelService variavelService){
        this.variavelService = variavelService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> linhas = obterLinhasDeArquivo("Dados/variaveis.tsv", true);
        String[] campos;

        for(String linha : linhas){
            campos = linha.split("\t");

            Variavel variavel = new Variavel();

            variavel.setNome(campos[0]);
            variavel.setDescricao(campos[1]);

            variavelService.incluir(variavel);
        }
    }
}
