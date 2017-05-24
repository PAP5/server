package br.com.pap5.ejb.remote;

import javax.ejb.Remote;
import br.com.pap5.dao.bo.UsuarioDAOMetodos;

@Remote
public interface UsuarioRemote extends UsuarioDAOMetodos{

}
