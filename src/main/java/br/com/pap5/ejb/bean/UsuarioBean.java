package br.com.pap5.ejb.bean;

import br.com.pap5.ejb.remote.UsuarioRemote;
import br.com.pap5.bo.Usuario;
import br.com.pap5.dao.bo.UsuarioDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsuarioBean implements UsuarioRemote {

    @PersistenceContext(unitName = "pap5PU")
    protected EntityManager em;

    @Override
    public Usuario salvar(Usuario o) throws Exception {
        return new UsuarioDAO(em).salvar(o);
    }

    @Override
    public void remover(Usuario o) {
        new UsuarioDAO(em).remover(o);
    }

    @Override
    public Usuario consultarPorId(Long id) {
        return new UsuarioDAO(em).consultarPorId(id);
    }

    @Override
    public List<Usuario> consultarTodos() {
        return new UsuarioDAO(em).consultarTodos();
    }

    @Override
    public Usuario consultarPorUsuario(String usuario) {
        return new UsuarioDAO(em).consultarPorUsuario(usuario);
    }
}