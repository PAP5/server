package br.com.pap5.dao.bo;

import br.com.pap5.bo.PF;
import br.com.pap5.dao.CRUD;

public interface PFDAOMetodos extends CRUD<PF>{
    public PF consultarPorUsuario(Long id);
}
