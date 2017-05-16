package br.com.pap5.ejb;

import br.com.pap5.bo.Usuario;
import br.com.pap5.dao.CRUD;
import javax.ejb.Remote;

@Remote
public interface UsuarioRemote extends CRUD<Usuario> {

}
