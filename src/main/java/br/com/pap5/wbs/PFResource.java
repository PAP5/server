package br.com.pap5.wbs;

import br.com.pap5.bo.PF;
import br.com.pap5.ejb.PFRemote;
import javax.ejb.EJB;
import javax.ws.rs.Path;

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

    @Override
    public String postJson(String json) {
       try{
           PF pf = gson.fromJson(json, PF.class);
           return gson.toJson(ejb.salvar(pf));
       }
       catch(Exception e){
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
