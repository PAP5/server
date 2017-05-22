package br.com.pap5.ejb;

import br.com.pap5.bo.PJ;
import br.com.pap5.dao.PJDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PJBean implements PJRemote{

    @PersistenceContext(unitName = "pap5PU")
    protected EntityManager em;
    
    @Override
    public PJ salvar(PJ o) throws Exception {
        return new PJDAO(em).salvar(o);
    }

    @Override
    public void remover(PJ o) {
        new PJDAO(em).remover(o);
    }

    @Override
    public PJ consultarPorId(Long id) {
        return new PJDAO(em).consultarPorId(id);
    }

    @Override
    public List<PJ> consultarTodos() {
        return new PJDAO(em).consultarTodos();
    }

    @Override
    public PJ consultarPorUsuario(Long id) {
        return new PJDAO(em).consultarPorUsuario(id);
    }
}
