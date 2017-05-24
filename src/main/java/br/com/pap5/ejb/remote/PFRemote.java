package br.com.pap5.ejb.remote;

import javax.ejb.Remote;
import br.com.pap5.dao.bo.PFDAOMetodos;

@Remote
public interface PFRemote extends PFDAOMetodos{
    
}
