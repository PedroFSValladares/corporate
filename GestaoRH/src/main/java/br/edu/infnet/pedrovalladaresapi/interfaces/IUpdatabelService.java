package br.edu.infnet.pedrovalladaresapi.interfaces;

public interface IUpdatabelService<T, ID>{
    T alterar(ID id, T entidade);
}
