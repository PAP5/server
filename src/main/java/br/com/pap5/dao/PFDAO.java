package br.com.pap5.dao;

import br.com.pap5.bo.PF;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PFDAO extends DAO<PF> {

    public PFDAO(EntityManager em) {
        super(em);
    }

    @Override
    public PF salvar(PF pf) throws Exception {
        if (pf.getId() == null) {
            em.persist(pf);
        } else {
            if (!em.contains(pf)) {
                if (em.find(PF.class, pf.getId()) == null) {
                    throw new Exception("Erro ao atualizar pessoa física");
                }
            }
            pf = em.merge(pf);
        }
        return pf;
    }

    @Override
    public void remover(PF pf) {
        if (em.contains(pf)) {
            em.remove(pf);
        }
    }

    @Override
    public PF consultarPorId(Long id) {
        return em.find(PF.class, id);
    }

    @Override
    public List<PF> consultarTodos() {
        Query q = em.createNamedQuery("PF.consultarTodos");
        return q.getResultList();
    }
}