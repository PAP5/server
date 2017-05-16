package br.com.pap5.wbs;

import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public abstract class DefaultResource {
    protected Gson gson = new Gson();
        
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public abstract String getJson();
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public abstract String getJson(@PathParam("id") String id);
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public abstract String postJson(String json);
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public abstract void putJson(String json);
    
    @DELETE
    @Path("/{id}")
    public abstract void deleteJson(final @PathParam("id") String id);
}
