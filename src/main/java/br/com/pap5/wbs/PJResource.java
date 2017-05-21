package br.com.pap5.wbs;

import br.com.pap5.bo.PJ;
import br.com.pap5.ejb.PJRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Path;

@Path("pj")
public class PJResource extends DefaultResource{

    @EJB
    protected PJRemote ejb;
    
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
            PJ pj = gson.fromJson(json, PJ.class);
            return gson.toJson(ejb.salvar(pj));
        } catch (Exception e) {
            Logger.getLogger(PJResource.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    @Override
    public void putJson(String json) {
        postJson(json);
    }

    @Override
    public void deleteJson(String id) {
        PJ pj = ejb.consultarPorId(Long.valueOf(id));
        ejb.remover(pj);
    }
    
}
