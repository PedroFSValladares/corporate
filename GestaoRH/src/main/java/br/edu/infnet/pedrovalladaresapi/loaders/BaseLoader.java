package br.edu.infnet.pedrovalladaresapi.loaders;

import org.springframework.boot.ApplicationRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLoader implements ApplicationRunner {
    public List<String> obterLinhasDeArquivo(String nomeDoArquivo, Boolean ignorarCabecalho) throws IOException {
        File file = new File(nomeDoArquivo);
        if(file.exists()){
            FileReader arquivo = new FileReader(file);
            BufferedReader leitura = new BufferedReader(arquivo);

            List<String> linhas = new ArrayList<>(leitura.lines().toList());
            if (ignorarCabecalho)
                linhas.remove(0);
            arquivo.close();
            return linhas;
        }else{
            System.err.println("Erro ao tentar abrir o arquivo:" + file.getAbsolutePath());
            return new ArrayList<>();
        }
    }
}
