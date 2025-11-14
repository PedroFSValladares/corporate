package br.edu.infnet.pedrovalladaresapi.loaders;

import br.edu.infnet.pedrovalladaresapi.domain.models.transporte.Transporte;
import br.edu.infnet.pedrovalladaresapi.services.TransporteService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class TransporteLoader extends BaseLoader {

    private final TransporteService transporteService;

    public TransporteLoader(TransporteService transporteService){
        this.transporteService = transporteService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[] campos;
        var linhas = obterLinhasDeArquivo("Dados/Transportes.tsv", true);

        for(String linha : linhas){
            campos = linha.split("\t");
            Transporte transporte = new Transporte();

            transporte.setCodigo(campos[0]);

            transporte.setItinerario(campos[1]);

            Double tarifa = Double.parseDouble(campos[2].replace("R$ ", "").replace(",", "."));
            transporte.setTarifa(tarifa);

            transporte.setEstado(campos[3]);

            transporteService.incluir(transporte);
        }
    }
}
