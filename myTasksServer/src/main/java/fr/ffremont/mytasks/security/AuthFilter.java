/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ffremont.mytasks.security;

import fr.ffremont.mytasks.dao.UserDao;
import fr.ffremont.mytasks.model.Role;
import fr.ffremont.mytasks.model.User;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author florent
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthFilter implements ContainerRequestFilter {

    private final static Logger LOG = LoggerFactory.getLogger(AuthFilter.class);
    
    @Inject
    UserDao userDao;
    
    @Override
    public void filter(ContainerRequestContext requestContext) {
        LOG.debug("AuthFilter process...");
        String authValue = requestContext.getHeaderString("authorization");
         
        if(authValue == null){
            LOG.debug("Unauthorized : no auth header");
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }
        
        requestContext.setSecurityContext(new UserSecurityContext(new UserPrincipal(userDao.findUserByHash(authValue.replace(UserSecurityContext.AUTH_SCHEMA+" ", "")))));
    }
    
}
