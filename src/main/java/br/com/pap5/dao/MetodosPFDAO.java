package br.com.pap5.dao;

import br.com.pap5.bo.PF;

public interface MetodosPFDAO extends CRUD<PF>{
    public PF consultarPorUsuario(Long id);
}
