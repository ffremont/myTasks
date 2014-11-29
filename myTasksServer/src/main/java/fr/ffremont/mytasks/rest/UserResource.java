/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ffremont.mytasks.rest;

import fr.ffremont.mytasks.dao.UserDao;
import fr.ffremont.mytasks.exception.NotFoundEntity;
import fr.ffremont.mytasks.model.Role;
import fr.ffremont.mytasks.rest.model.Login;
import fr.ffremont.mytasks.security.UserPrincipal;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.omg.CosNaming.NamingContextPackage.NotFound;
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
@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
public class UserResource {

    private final static Logger LOG = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    MongoTemplate mongoTpl;
    
    @Autowired
    UserDao userDao;

    @Context
    private UriInfo uri;
    
    @Context 
    private SecurityContext sc;

    @POST
    public Response create(Login task) {
        return Response.created(uri.getBaseUri()).build();
    }
    
    @RolesAllowed({Role.USER, Role.MANAGER, Role.ADMIN})
    @GET
    public Response get() { 
        return Response.ok().entity(((UserPrincipal)sc.getUserPrincipal()).getCurrentUser()).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response login(@FormParam("login") String login, @FormParam("password") String password) throws NotFoundEntity{
        byte[] hash = DigestUtils.sha256(login+password);
        
        fr.ffremont.mytasks.model.User user = userDao.findUserByHash(new String(hash));
        
        if(user == null){
            LOG.debug("échec de la connexion : "+login+":"+password);
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }
        
        return Response.ok().entity(user).build();
    }
}
