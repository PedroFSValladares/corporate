package br.edu.infnet.pedrovalladaresapi.domain.repositories;

import br.edu.infnet.pedrovalladaresapi.domain.models.math.Calculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICalculoRepository extends JpaRepository<Calculo, Integer> {
}
