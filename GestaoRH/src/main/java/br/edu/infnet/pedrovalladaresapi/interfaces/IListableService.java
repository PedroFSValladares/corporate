package br.edu.infnet.pedrovalladaresapi.interfaces;

import java.util.List;

public interface IListableService<T>{
    List<T> listarTodos();
}
