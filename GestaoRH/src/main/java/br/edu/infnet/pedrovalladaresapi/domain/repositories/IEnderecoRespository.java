package br.edu.infnet.pedrovalladaresapi.domain.repositories;

import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnderecoRespository extends JpaRepository<Endereco, String> {
}
