package br.com.pap5.wbs;

import br.com.pap5.bo.PF;
import br.com.pap5.bo.PJ;
import br.com.pap5.bo.Usuario;
import br.com.pap5.ejb.remote.UsuarioRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("usuario")
public class UsuarioResource extends DefaultResource {

    @EJB
    protected UsuarioRemote ejb;

    @Override
    public String getJson() {
        return gson.toJson(ejb.consultarTodos());
    }

    @Override
    public String getJson(String id) {
        return gson.toJson(ejb.consultarPorId(Long.parseLong(id)));
    }

    @Override
    public String postJson(String json) {
        try {
            Usuario u = gson.fromJson(json, Usuario.class);
            return gson.toJson(ejb.salvar(u));
        } catch (Exception e) {
            Logger.getLogger(UsuarioResource.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    @Path("{id}/perfil")
    @GET
    @Produces(DefaultResource.PRODUZ)
    public String getJsonPerfil(@PathParam("id") String id) {
        PF pf = ejb.consultarPerfilPF(Long.parseLong(id));
        if (pf != null) {
            return gson.toJson(pf);
        }
        PJ pj = ejb.consultarPerfilPJ(Long.parseLong(id));
        if (pj != null) {
            return gson.toJson(pj);
        }
        return "[]";

    }

    @Override
    public void putJson(String json) {
        postJson(json);
    }

    @Override
    public void deleteJson(String id) {
        Usuario u = ejb.consultarPorId(Long.valueOf(id));
        ejb.remover(u);
    }
}
