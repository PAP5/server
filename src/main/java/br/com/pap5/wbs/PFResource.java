package br.com.pap5.wbs;

import br.com.pap5.bo.PF;
import br.com.pap5.ejb.PFRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("pf")
public class PFResource extends DefaultResource {

    @EJB
    protected PFRemote ejb;

    @Override
    public String getJson() {
        return gson.toJson(ejb.consultarTodos());
    }

    @Override
    public String getJson(String id) {
        return gson.toJson(ejb.consultarPorId(Long.parseLong(id)));
    }

    @Path("usuario/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsuarioPF(@PathParam("id") String id) {
        try {
            PF pf = ejb.consultarPorUsuario(Long.parseLong(id));
            if (pf != null) {
                return gson.toJson(pf);
            } else {
                return "false";
            }
        } catch (Exception e) {
            Logger.getLogger(PFResource.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    @Override
    public String postJson(String json) {
        try {
            PF pf = gson.fromJson(json, PF.class);
            return gson.toJson(ejb.salvar(pf));
        } catch (Exception e) {
            Logger.getLogger(PFResource.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    @Override
    public void putJson(String json) {
        postJson(json);
    }

    @Override
    public void deleteJson(String id) {
        PF pf = ejb.consultarPorId(Long.valueOf(id));
        ejb.remover(pf);
    }
}
