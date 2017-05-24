package br.com.pap5.wbs;

import br.com.pap5.bo.Doacao;
import br.com.pap5.ejb.remote.DoacaoRemote;
import javax.ejb.EJB;
import javax.ws.rs.Path;

@Path("doacao")
public class DoacaoResource extends DefaultResource{

    @EJB
    protected DoacaoRemote ejb;
    
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
           Doacao o = gson.fromJson(json, Doacao.class);
           return gson.toJson(ejb.salvar(o));
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
        Doacao o = ejb.consultarPorId(Long.valueOf(id));
        ejb.remover(o);
    }
    
}
