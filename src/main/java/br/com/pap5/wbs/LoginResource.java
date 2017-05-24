package br.com.pap5.wbs;

import br.com.pap5.bo.Usuario;
import br.com.pap5.ejb.UsuarioRemote;
import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("login")
public class LoginResource {

    @EJB
    protected UsuarioRemote ejb;

    @GET
    @Path("{usuario}/{senha}")
    @Produces(DefaultResource.PRODUZ)
    public String getJson(@PathParam("usuario") String usuario, @PathParam("senha") String senha) {
        Usuario u;
        try {
            u = ejb.consultarPorUsuario(usuario);
            if (u.getSenha().equals(senha)){
                return new Gson().toJson(u);
            }
        } catch (Exception e) {
            return "false";
        }
        return "false";
    }
}
