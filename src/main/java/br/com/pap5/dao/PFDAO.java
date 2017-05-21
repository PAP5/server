package br.com.pap5.dao;

import br.com.pap5.bo.PF;
import br.com.pap5.bo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PFDAO extends DAO implements MetodosPFDAO{

    public PFDAO(EntityManager em) {
        super(em);
    }

    @Override
    public PF salvar(PF o) throws Exception {
        Usuario u = new UsuarioDAO(em).consultarPorId(o.getUsuario().getId());
        o.setUsuario(u);
        
        if (o.getId() == null) {
            em.persist(o);
        } else {
            if (!em.contains(o)) {
                if (em.find(PF.class, o.getId()) == null) {
                    throw new Exception("Erro ao atualizar pessoa física");
                }
            }
            o = em.merge(o);
        }
        return o;
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