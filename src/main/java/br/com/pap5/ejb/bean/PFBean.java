package br.com.pap5.ejb.bean;

import br.com.pap5.ejb.remote.PFRemote;
import br.com.pap5.bo.PF;
import br.com.pap5.dao.bo.PFDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PFBean implements PFRemote {

    @PersistenceContext(unitName = "pap5PU")
    protected EntityManager em;

    @Override
    public PF salvar(PF pf) throws Exception {
        return new PFDAO(em).salvar(pf);
    }

    @Override
    public void remover(PF pf) {
        new PFDAO(em).remover(pf);
    }

    @Override
    public PF consultarPorId(Long id) {
        return new PFDAO(em).consultarPorId(id);
    }

    @Override
    public List<PF> consultarTodos() {
        return new PFDAO(em).consultarTodos();
    }

    @Override
    public PF consultarPorUsuario(Long id) {
        return new PFDAO(em).consultarPorUsuario(id);
    }
}