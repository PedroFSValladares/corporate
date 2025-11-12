package br.edu.infnet.pedrovalladaresapi.loaders;

import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Cargo;
import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Endereco;
import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Funcionario;
import br.edu.infnet.pedrovalladaresapi.services.FuncionariosService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Order(2)
@Component
public class FuncionarioLoader extends BaseLoader{

    private final FuncionariosService funcionariosService;

    public FuncionarioLoader(FuncionariosService funcionariosService){
        this.funcionariosService = funcionariosService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[] campos = null;

        var linhas = obterLinhasDeArquivo("Dados/FuncionariosV2.tsv", true);

        for (String linha : linhas){
            campos = linha.split("\t");

            Funcionario funcionario = new Funcionario();

            funcionario.setNome(campos[0]);
            funcionario.setCpf(campos[1]);
            funcionario.setEmail(campos[2]);

            String telefone = campos[3].replace("(","")
                    .replace(")", "")
                    .replace("-","")
                    .replace(" ", "");

            funcionario.setTelefone(telefone);
            funcionario.setMatricula(funcionario.gerarMatricula());
            funcionario.setAtivo(true);

            String cep = campos[4].replace("-", "");
            Endereco endereco = new Endereco();
            endereco.setCEP(cep);
            endereco.setLogradouro(campos[5]);
            endereco.setComplemento(campos[6]);
            endereco.setBairro(campos[7]);
            endereco.setUF(campos[8]);

            Cargo cargo = new Cargo();
            cargo.setId(Integer.parseInt(campos[10]));

            funcionario.setEndereco(endereco);
            funcionario.setCargo(cargo);

            funcionariosService.incluir(funcionario);
        }

        Collection<Funcionario> funcionarios = funcionariosService.listarTodos();
        funcionarios.forEach(System.out::println);
    }

}
