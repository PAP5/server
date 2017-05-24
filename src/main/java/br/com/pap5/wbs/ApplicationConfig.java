package br.com.pap5.wbs;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.pap5.wbs.DoacaoResource.class);
        resources.add(br.com.pap5.wbs.InstituicaoResource.class);
        resources.add(br.com.pap5.wbs.LoginResource.class);
        resources.add(br.com.pap5.wbs.PFResource.class);
        resources.add(br.com.pap5.wbs.PJResource.class);
        resources.add(br.com.pap5.wbs.UsuarioResource.class);
    }   
}