package br.com.pap5.ejb;

import br.com.pap5.bo.PF;
import br.com.pap5.dao.CRUD;
import javax.ejb.Remote;

@Remote
public interface PFRemote extends CRUD<PF>{
    
}
