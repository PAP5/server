package br.com.pap5.ejb;

import javax.ejb.Remote;
import br.com.pap5.dao.MetodosUsuarioDAO;

@Remote
public interface UsuarioRemote extends MetodosUsuarioDAO{

}
