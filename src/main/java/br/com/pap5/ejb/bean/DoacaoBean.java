package br.com.pap5.ejb.bean;

import br.com.pap5.bo.Doacao;
import br.com.pap5.dao.bo.DoacaoDAO;
import br.com.pap5.ejb.remote.DoacaoRemote;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DoacaoBean implements DoacaoRemote{

    @PersistenceContext(unitName = "pap5PU")
    protected EntityManager em;
    
    @Override
    public Doacao salvar(Doacao o) throws Exception {
        return new DoacaoDAO(em).salvar(o);
    }

    @Override
    public void remover(Doacao o) {
        new DoacaoDAO(em).remover(o);
    }

    @Override
    public Doacao consultarPorId(Long id) {
        return new DoacaoDAO(em).consultarPorId(id);
    }

    @Override
    public List<Doacao> consultarTodos() {
        return new DoacaoDAO(em).consultarTodos();
    }

    @Override
    public List<Doacao> consultarDoacaoPorUsuario(Long id) {
        return new DoacaoDAO(em).consultarDoacaoPorUsuario(id);
    }
    
}
