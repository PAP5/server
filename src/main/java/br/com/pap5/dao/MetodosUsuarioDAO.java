package br.com.pap5.dao;

import br.com.pap5.bo.Usuario;

public interface MetodosUsuarioDAO extends CRUD<Usuario>{
    public Usuario consultarPorUsuario(String usuario);
}
