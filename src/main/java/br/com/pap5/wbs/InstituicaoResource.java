package br.com.pap5.wbs;

import br.com.pap5.bo.Instituicao;
import br.com.pap5.ejb.remote.InstituicaoRemote;
import javax.ejb.EJB;
import javax.ws.rs.Path;

@Path("instituicao")
public class InstituicaoResource extends DefaultResource{

    @EJB
    protected InstituicaoRemote ejb;
    
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
           Instituicao o = gson.fromJson(json, Instituicao.class);
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
        Instituicao o = ejb.consultarPorId(Long.valueOf(id));
        ejb.remover(o);
    }
    
}
