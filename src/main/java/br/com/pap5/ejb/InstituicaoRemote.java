package br.com.pap5.ejb;

import br.com.pap5.dao.MetodosInstituicaoDAO;
import javax.ejb.Remote;

@Remote
public interface InstituicaoRemote extends MetodosInstituicaoDAO{
    
}
