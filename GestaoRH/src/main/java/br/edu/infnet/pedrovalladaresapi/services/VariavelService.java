package br.edu.infnet.pedrovalladaresapi.services;

import br.edu.infnet.pedrovalladaresapi.domain.models.math.Variavel;
import br.edu.infnet.pedrovalladaresapi.domain.repositories.IVariavelRepository;
import br.edu.infnet.pedrovalladaresapi.interfaces.IIdQueryableService;
import br.edu.infnet.pedrovalladaresapi.interfaces.IIncludableService;
import org.springframework.stereotype.Service;

@Service
public class VariavelService implements IIncludableService<Variavel>, IIdQueryableService<Variavel, String> {

    private final IVariavelRepository variavelRepository;

    public VariavelService(IVariavelRepository variavelRepository){
        this.variavelRepository = variavelRepository;
    }

    @Override
    public Variavel incluir(Variavel entidade) {
        return variavelRepository.save(entidade);
    }

    @Override
    public Variavel obterPorId(String s) {
        return variavelRepository.findById(s).orElse(null);
    }
}
