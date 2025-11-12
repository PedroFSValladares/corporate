package br.edu.infnet.pedrovalladaresapi.services;

import br.edu.infnet.pedrovalladaresapi.domain.models.transporte.Transporte;
import br.edu.infnet.pedrovalladaresapi.domain.repositories.ITransporteRepository;
import br.edu.infnet.pedrovalladaresapi.interfaces.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransporteService implements
        IIncludableService<Transporte>, IUpdatabelService<Transporte, String>, IListableService<Transporte>, IDeletableService<String>, IIdQueryableService<Transporte, String> {
    private final ITransporteRepository transporteRepository;

    public TransporteService(ITransporteRepository transporteRepository){
        this.transporteRepository = transporteRepository;
    }

    @Override
    public Transporte incluir(Transporte entidade) {
        entidade.setAtivo(true);
        return transporteRepository.save(entidade);
    }

    @Override
    public List<Transporte> listarTodos() {
        return transporteRepository.findAll();
    }

    @Override
    public Transporte alterar(String s, Transporte entidade) {
        if(!transporteRepository.existsById(s))
            return null;
        return transporteRepository.save(entidade);
    }

    @Override
    public void deletar(String s) {
        transporteRepository.deleteById(s);
    }

    @Override
    public Transporte obterPorId(String s){
        return transporteRepository.findById(s).orElse(null);
    }

}
