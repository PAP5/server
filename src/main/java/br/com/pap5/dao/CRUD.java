package br.com.pap5.dao;

import java.util.List;

public interface CRUD<T> {
    
    public abstract T salvar(T o) throws Exception;
    public void remover(T o);
    public T consultarPorId(Long id);
    public List<T> consultarTodos();
}
