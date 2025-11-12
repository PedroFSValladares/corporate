package br.edu.infnet.pedrovalladaresapi.interfaces;

public interface IIdQueryableService<T, ID> {
    T obterPorId(ID id);
}
