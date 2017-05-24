package br.com.pap5.dao.bo;

import br.com.pap5.bo.Usuario;
import br.com.pap5.dao.CRUD;

public interface UsuarioDAOMetodos extends CRUD<Usuario>{
    public Usuario consultarPorUsuario(String usuario);
}
