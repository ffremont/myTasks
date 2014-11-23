/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ffremont.mytasks.rest;

import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
public class Task {
    
    private final static Logger LOG = LoggerFactory.getLogger(Task.class);

    @Autowired
    MongoTemplate mongoTpl;
    
    @Context
    private UriInfo uri;
    
    @POST
    public Response create(Task task){
        mongoTpl.insert(task);
        
        return Response.created(uri.getBaseUri()).build();
    }
    
    @POST
    @Path("/search")
    public Response search(){
        
        
        return Response.ok().build();
    }
}
