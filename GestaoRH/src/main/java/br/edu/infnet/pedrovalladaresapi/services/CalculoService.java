package br.edu.infnet.pedrovalladaresapi.services;

import br.edu.infnet.pedrovalladaresapi.domain.models.math.Calculo;
import br.edu.infnet.pedrovalladaresapi.domain.repositories.ICalculoRepository;
import br.edu.infnet.pedrovalladaresapi.interfaces.IDeletableService;
import br.edu.infnet.pedrovalladaresapi.interfaces.IIdQueryableService;
import br.edu.infnet.pedrovalladaresapi.interfaces.IIncludableService;
import br.edu.infnet.pedrovalladaresapi.interfaces.IUpdatabelService;
import org.springframework.stereotype.Service;

@Service
public class CalculoService implements IIncludableService<Calculo>, IIdQueryableService<Calculo, Integer>, IUpdatabelService<Calculo, Integer>, IDeletableService<Integer> {

    private final ICalculoRepository calculoRepository;

    public CalculoService(ICalculoRepository calculoRepository){
        this.calculoRepository = calculoRepository;
    }

    @Override
    public void deletar(Integer integer) {
        calculoRepository.deleteById(integer);
    }

    @Override
    public Calculo obterPorId(Integer integer) {
        return calculoRepository.findById(integer).orElse(null);
    }

    @Override
    public Calculo incluir(Calculo entidade) {
        return calculoRepository.save(entidade);
    }

    @Override
    public Calculo alterar(Integer integer, Calculo entidade) {
        Calculo calculo = obterPorId(integer);
        if(calculo == null)
            return null;
        else{
            calculo.setNome(entidade.getNome());
            calculo.setCalculo(entidade.getCalculo());
            calculo.setAplicavelEmTodos(entidade.isAplicavelEmTodos());
            calculo.setCalculo(entidade.getCalculo());
        }
        return calculoRepository.save(calculo);
    }
}
