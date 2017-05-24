package br.com.pap5.dao.bo;

import br.com.pap5.bo.PJ;
import br.com.pap5.dao.CRUD;

public interface PJDAOMetodos extends CRUD<PJ>{
    public PJ consultarPorUsuario(Long id);
}
