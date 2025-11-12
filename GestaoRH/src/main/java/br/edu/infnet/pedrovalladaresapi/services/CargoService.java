package br.edu.infnet.pedrovalladaresapi.services;

import br.edu.infnet.pedrovalladaresapi.domain.models.pessoal.Cargo;
import br.edu.infnet.pedrovalladaresapi.domain.repositories.ICargoRepository;
import br.edu.infnet.pedrovalladaresapi.interfaces.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService implements
        IIncludableService<Cargo>, IUpdatabelService<Cargo, Integer>, IListableService<Cargo>, IIdQueryableService<Cargo, Integer>, IInativableService<Integer> {

    private final ICargoRepository cargoRepository;

    public CargoService(ICargoRepository cargoRepository){
        this.cargoRepository = cargoRepository;
    }

    @Override
    public Cargo incluir(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public List<Cargo> listarTodos() {
        return cargoRepository.findAll();
    }

    @Override
    public Cargo alterar(Integer id, Cargo cargo) {
        Cargo cargoASerAlterado = obterPorId(id);

        if (cargoASerAlterado == null)
            return null;
        else
            return cargoRepository.save(cargo);
    }

    @Override
    public Cargo obterPorId(Integer id){
        return cargoRepository.findById(id).orElse(null);
    }

    @Override
    public void inativar(Integer id){
        Cargo cargo = obterPorId(id);

        if (cargo != null){
            cargo.setAtivo(false);
            cargoRepository.save(cargo);
        }
    }
}
