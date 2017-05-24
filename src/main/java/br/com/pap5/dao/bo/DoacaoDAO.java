package br.com.pap5.dao.bo;

import br.com.pap5.bo.Doacao;
import br.com.pap5.bo.Instituicao;
import br.com.pap5.bo.PF;
import br.com.pap5.bo.PJ;
import br.com.pap5.dao.DAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DoacaoDAO extends DAO implements DoacaoMetodos {

    public DoacaoDAO(EntityManager em) {
        super(em);
    }

    @Override
    public Doacao salvar(Doacao o) throws Exception {
        Instituicao i = new InstituicaoDAO(em).consultarPorId(o.getInstituicao().getId());
        PF pf = null;
        PJ pj = null;
        try {
            pf = new PFDAO(em).consultarPorId(o.getPf().getId());
        } catch (Exception e) {
            try {
                pj = new PJDAO(em).consultarPorId(o.getPj().getId());
            } catch (Exception e2) {

            }
        }
        o.setInstituicao(i);
        o.setPf(pf);
        o.setPj(pj);

        if (o.getId() == null) {
            em.persist(o);
        } else {
            if (!em.contains(o)) {
                if (em.find(Doacao.class, o.getId()) == null) {
                    throw new Exception("Erro ao atualizar doacao");
                }
            }
            o = em.merge(o);
        }
        return o;
    }

    @Override
    public void remover(Doacao o) {
        Doacao d = em.find(Doacao.class, o.getId());
        if (em.contains(d)) {
            em.remove(d);
        }
    }

    @Override
    public Doacao consultarPorId(Long id) {
        return em.find(Doacao.class, id);
    }

    @Override
    public List<Doacao> consultarTodos() {
        Query q = em.createNamedQuery("Doacao.consultarTodos");
        return q.getResultList();
    }

}
