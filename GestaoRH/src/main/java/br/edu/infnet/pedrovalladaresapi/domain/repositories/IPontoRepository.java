package br.edu.infnet.pedrovalladaresapi.domain.repositories;

import br.edu.infnet.pedrovalladaresapi.domain.models.frequencia.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPontoRepository extends JpaRepository<Ponto, Integer> {
    @Query("SELECT p FROM Ponto p WHERE p.Data = :data AND p.Funcionario.Cpf = :cpf")
    List<Ponto> findByDataAndFuncionario(@Param("data") LocalDate data, @Param("cpf") String cpf);
    @Query("SELECT p FROM Ponto p WHERE EXTRACT(MONTH FROM p.Data) = :mes AND p.Funcionario.Cpf = :cpf")
    List<Ponto> findByMesAndFuncionario(@Param("mes") int mes, @Param("cpf") String cpf);
}
