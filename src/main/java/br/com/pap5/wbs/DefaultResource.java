package br.com.pap5.wbs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

    static final String PRODUZ = MediaType.APPLICATION_JSON + ";charset=utf-8";
    
    protected Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    
    @GET
    @Produces(DefaultResource.PRODUZ)
    public abstract String getJson();

    @Path("{id}")
    @GET
    @Produces(DefaultResource.PRODUZ)
    public abstract String getJson(@PathParam("id") String id);

    @POST
    @Produces(DefaultResource.PRODUZ)
    @Consumes(DefaultResource.PRODUZ)
    public abstract String postJson(String json);

    @PUT
    @Consumes(DefaultResource.PRODUZ)
    public abstract void putJson(String json);

    @DELETE
    @Path("/{id}")
    public abstract void deleteJson(final @PathParam("id") String id);
}
