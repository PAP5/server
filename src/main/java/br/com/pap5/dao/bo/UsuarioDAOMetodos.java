package br.com.pap5.dao.bo;

import br.com.pap5.bo.PF;
import br.com.pap5.bo.PJ;
import br.com.pap5.bo.Usuario;
import br.com.pap5.dao.CRUD;

public interface UsuarioDAOMetodos extends CRUD<Usuario>{
    public Usuario consultarPorUsuario(String usuario);
    public PF consultarPerfilPF(Long id);
    public PJ consultarPerfilPJ(Long id);
    
}
