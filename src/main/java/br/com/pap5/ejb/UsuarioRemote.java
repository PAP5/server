package br.com.pap5.ejb;

import br.com.pap5.bo.Usuario;
import br.com.pap5.dao.CRUD;
import javax.ejb.Remote;
import br.com.pap5.dao.MetodosUsuarioDAO;

@Remote
public interface UsuarioRemote extends CRUD<Usuario>, MetodosUsuarioDAO{

}
