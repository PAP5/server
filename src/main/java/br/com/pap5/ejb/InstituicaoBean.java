package br.com.pap5.ejb;

import br.com.pap5.bo.Instituicao;
import br.com.pap5.dao.InstituicaoDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class InstituicaoBean implements InstituicaoRemote{

    @PersistenceContext(unitName = "pap5PU")
    protected EntityManager em;

    @Override
    public Instituicao salvar(Instituicao o) throws Exception {
        return new InstituicaoDAO(em).salvar(o);
    }

    @Override
    public void remover(Instituicao o) {
        new InstituicaoDAO(em).remover(o);
    }

    @Override
    public Instituicao consultarPorId(Long id) {
        return new InstituicaoDAO(em).consultarPorId(id);
    }

    @Override
    public List<Instituicao> consultarTodos() {
        return new InstituicaoDAO(em).consultarTodos();
    }   
}
