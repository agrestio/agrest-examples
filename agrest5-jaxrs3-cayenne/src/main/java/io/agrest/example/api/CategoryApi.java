package io.agrest.example.api;

import io.agrest.DataResponse;
import io.agrest.SimpleResponse;
import io.agrest.example.persistent.Category;
import io.agrest.jaxrs3.AgJaxrs;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("category")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryApi {

    @Context
    private Configuration config;

    @POST
    public SimpleResponse create(String data) {
        return AgJaxrs.create(Category.class, config).sync(data);
    }

    @GET
    public DataResponse<Category> getAll(@Context UriInfo uriInfo) {
        return AgJaxrs.select(Category.class, config).clientParams(uriInfo.getQueryParameters()).get();
    }
}
