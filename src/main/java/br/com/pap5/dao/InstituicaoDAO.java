package br.com.pap5.dao;

import br.com.pap5.bo.Instituicao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class InstituicaoDAO extends DAO implements MetodosInstituicaoDAO {

    public InstituicaoDAO(EntityManager em) {
        super(em);
    }

    @Override
    public Instituicao salvar(Instituicao o) throws Exception {
        if (o.getId() == null) {
            em.persist(o);
        } else {
            if (!em.contains(o)) {
                if (em.find(Instituicao.class, o.getId()) == null) {
                    throw new Exception("Erro ao atualizar instituicao");
                }
            }
            o = em.merge(o);
        }
        return o;
    }

    @Override
    public void remover(Instituicao o) {
        if (em.contains(o)) {
            em.remove(o);
        }
    }

    @Override
    public Instituicao consultarPorId(Long id) {
        return em.find(Instituicao.class, id);
    }

    @Override
    public List<Instituicao> consultarTodos() {
        Query q = em.createNamedQuery("Instituicao.consultarTodos");
        return q.getResultList();
    }

}
