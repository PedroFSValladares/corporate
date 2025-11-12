package br.edu.infnet.pedrovalladaresapi.domain.repositories;

import br.edu.infnet.pedrovalladaresapi.domain.models.math.Variavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVariavelRepository extends JpaRepository<Variavel, String> {
}
