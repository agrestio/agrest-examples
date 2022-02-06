package org.example.agrest.api;

import io.agrest.Ag;
import io.agrest.DataResponse;
import io.agrest.SimpleResponse;
import org.example.agrest.persistent.Category;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("category")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryApi {

    @Context
    private Configuration config;

    @POST
    public SimpleResponse create(String data) {
        return Ag.create(Category.class, config).sync(data);
    }

    @GET
    public DataResponse<Category> getAll(@Context UriInfo uriInfo) {
        return Ag.select(Category.class, config).uri(uriInfo).get();
    }
}
