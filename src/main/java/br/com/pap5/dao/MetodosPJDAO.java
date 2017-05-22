package br.com.pap5.dao;

import br.com.pap5.bo.PJ;

public interface MetodosPJDAO extends CRUD<PJ>{
    public PJ consultarPorUsuario(Long id);
}
