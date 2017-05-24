package br.com.pap5.ejb.remote;

import javax.ejb.Remote;
import br.com.pap5.dao.bo.InstituicaoDAOMetodos;

@Remote
public interface InstituicaoRemote extends InstituicaoDAOMetodos{
    
}
