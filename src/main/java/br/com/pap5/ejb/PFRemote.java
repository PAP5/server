package br.com.pap5.ejb;

import br.com.pap5.dao.MetodosPFDAO;
import javax.ejb.Remote;

@Remote
public interface PFRemote extends MetodosPFDAO{
    
}
