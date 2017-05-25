package br.com.pap5.dao.bo;

import br.com.pap5.bo.PF;
import br.com.pap5.bo.PJ;
import br.com.pap5.bo.Usuario;
import br.com.pap5.dao.DAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioDAO extends DAO implements UsuarioDAOMetodos {

    public UsuarioDAO(EntityManager em) {
        super(em);
    }

    @Override
    public Usuario salvar(Usuario o) throws Exception {
        if (o.getId() == null) {
            em.persist(o);
        } else {
            if (!em.contains(o)) {
                if (em.find(Usuario.class, o.getId()) == null) {
                    throw new Exception("Erro ao atualizar usuário");
                }
            }
            o = em.merge(o);
        }
        return o;
    }

    @Override
    public void remover(Usuario o) {
        Usuario u = em.find(Usuario.class, o.getId());
        if (em.contains(u)) {
            em.remove(u);
        }

    }

    @Override
    public Usuario consultarPorId(Long id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> consultarTodos() {
        Query q = em.createNamedQuery("Usuario.consultarTodos");
        return q.getResultList();
    }

    @Override
    public Usuario consultarPorUsuario(String usuario) {
        Query q = em.createNamedQuery("Usuario.consultarPorUsuario", Usuario.class);
        q.setParameter("usuario", usuario);
        return (Usuario) q.getSingleResult();
    }

    @Override
    public PF consultarPerfilPF(Long id) {
        Query q = em.createNamedQuery("Usuario.consultarPF", PF.class);
        q.setParameter("id", id);
        try {
            return (PF) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PJ consultarPerfilPJ(Long id) {
        Query q = em.createNamedQuery("Usuario.consultarPJ", PJ.class);
        q.setParameter("id", id);
        try {
            return (PJ) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
