package br.com.pap5.ejb;

import br.com.pap5.dao.MetodosPJDAO;
import javax.ejb.Remote;

@Remote
public interface PJRemote extends MetodosPJDAO{
    
}
