package br.edu.infnet.pedrovalladaresapi.loaders;

import br.edu.infnet.pedrovalladaresapi.domain.enuns.TipoCalculo;
import br.edu.infnet.pedrovalladaresapi.domain.models.math.Calculo;
import br.edu.infnet.pedrovalladaresapi.services.CalculoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class CalculoLoader extends BaseLoader {

    private final CalculoService calculoService;

    public CalculoLoader(CalculoService calculoService){
        this.calculoService = calculoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var linhas = obterLinhasDeArquivo("Dados/calculos.tsv", true);
        String[] campos;

        for(String linha : linhas){
            campos = linha.split("\t");

            Calculo calculo = new Calculo();

            calculo.setNome(campos[0]);
            calculo.setCalculo(campos[1]);
            calculo.setAplicavelEmTodos(campos[2].equals("sim"));
            calculo.setTipoCalculo(campos[3].equals("somativo") ? TipoCalculo.somativo : TipoCalculo.dedutivo);

            calculoService.incluir(calculo);
        }
    }
}
