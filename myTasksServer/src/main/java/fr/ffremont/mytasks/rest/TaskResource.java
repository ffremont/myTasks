/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ffremont.mytasks.rest;

import fr.ffremont.mytasks.model.Task;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author florent
 */
@Component
@Path("tasks")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource {
    
    private final static Logger LOG = LoggerFactory.getLogger(TaskResource.class);

    @Autowired
    MongoTemplate mongoTpl;
    
    @Context
    private UriInfo uri;
    
    @POST
    public Response add(Task task){
        mongoTpl.insert(task);
        
        return Response.created(uri.getBaseUri()).build();
    }
    
    @PUT
    public Response modify(Task task){
        //mongoTpl.insert(task);
        
        return Response.ok().build();
    }
    
    /**
     * Retoure la liste des tâches de + récente à la - récente (updated)
     * 
     * @param tags
     * @return 
     */
    @GET
    @Path("/tags/search")
    public Response searchByTags(@QueryParam("tag") final List<String> tags){
        
        
        return Response.ok().build();
    }
    
    @POST
    @Path("/search")
    public Response search(){
        
        
        return Response.ok().build();
    }
}
