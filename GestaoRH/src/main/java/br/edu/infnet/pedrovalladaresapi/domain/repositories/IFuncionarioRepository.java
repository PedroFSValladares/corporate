package br.edu.infnet.pedrovalladaresapi.domain.repositories;

import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFuncionarioRepository extends JpaRepository<Funcionario, String> {
}
