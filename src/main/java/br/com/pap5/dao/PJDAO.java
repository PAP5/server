package br.com.pap5.dao;

import br.com.pap5.bo.PJ;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PJDAO extends DAO implements MetodosPJDAO {

    public PJDAO(EntityManager em) {
        super(em);
    }

    @Override
    public PJ salvar(PJ o) throws Exception {
        if (o.getId() == null) {
            em.persist(o);
        } else {
            if(!em.contains(o)){
                if (em.find(PJ.class, o.getId()) == null) {
                    throw new Exception("Erro ao atualizar pessoa juridica");
                }
            }
            o = em.merge(o);
        }
        return o;
    }

    @Override
    public void remover(PJ o) {
        if (em.contains(o)) {
            em.remove(o);
        }
    }

    @Override
    public PJ consultarPorId(Long id) {
        return em.find(PJ.class, id);
    }

    @Override
    public List<PJ> consultarTodos() {
        Query q = em.createNamedQuery("PJ.consultarTodos");
        return q.getResultList();
    }
}
