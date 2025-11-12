package br.edu.infnet.pedrovalladaresapi.loaders;

import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Cargo;
import br.edu.infnet.pedrovalladaresapi.services.CargoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Order(1)
@Component
public class CargoLoader extends BaseLoader {

    private final CargoService cargoService;

    public CargoLoader(CargoService cargoService){
        this.cargoService = cargoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var linhas = obterLinhasDeArquivo("Dados/Cargos.tsv", true);
        String[] campos = null;

        for (String linha : linhas){
            campos = linha.split("\t");

            Cargo cargo = new Cargo();
            cargo.setNome(campos[1]);
            cargo.setRemuneracao(Double.valueOf(campos[2]));
            cargo.setValeAlimentacao(Double.valueOf(campos[3]));
            cargo.setValeTransporte(Double.valueOf(campos[4]));
            cargo.setAdicionalDePericulosidade(campos[5].equals("Sim"));
            cargo.setAdicionalDeInsalubridade(campos[6].equals("Sim"));
            cargo.setCargaHoraria(Integer.valueOf(campos[7]));
            cargo.setAtivo(true);

            cargoService.incluir(cargo);
        }

        Collection<Cargo> cargos = cargoService.listarTodos();
        cargos.forEach(System.out::println);
    }
}
