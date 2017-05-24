package br.com.pap5.ejb.remote;

import javax.ejb.Remote;
import br.com.pap5.dao.bo.PJDAOMetodos;

@Remote
public interface PJRemote extends PJDAOMetodos{
    
}
