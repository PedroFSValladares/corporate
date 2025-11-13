package br.edu.infnet.pedrovalladaresapi.loaders;

import br.edu.infnet.pedrovalladaresapi.domain.enuns.TipoViagem;
import br.edu.infnet.pedrovalladaresapi.domain.models.transporte.Transporte;
import br.edu.infnet.pedrovalladaresapi.domain.models.transporte.Viagem;
import br.edu.infnet.pedrovalladaresapi.services.FuncionariosService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(5)
public class ViagensLoader extends BaseLoader{

    private FuncionariosService funcionariosService;

    public ViagensLoader(FuncionariosService funcionariosService){
        this.funcionariosService = funcionariosService;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        var linhas = obterLinhasDeArquivo("Dados/viagens.tsv", true);
        String[] campos = null;

        var funcionario = funcionariosService.obterPorId("05194273193");
        List<Viagem> viagemList = new ArrayList<>();

        for(String linha : linhas){
            campos = linha.split("\t");

            Viagem viagem = new Viagem();

            Transporte transporte = new Transporte();
            transporte.setCodigo(campos[1]);
            viagem.setTransporte(transporte);
            viagem.setTipoViagem(campos[2].equals("ida") ? TipoViagem.ida : TipoViagem.volta);

            viagemList.add(viagem);
        }

        funcionario.setViagens(viagemList);
        funcionariosService.alterar("05194273193", funcionario);
    }
}
