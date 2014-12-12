/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ffremont.mytasks.security;

import fr.ffremont.mytasks.model.User;
import fr.ffremont.mytasks.repositories.UserRepository;
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

/**
 *
 * @author florent
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthFilter implements ContainerRequestFilter {

    private final static Logger LOG = LoggerFactory.getLogger(AuthFilter.class);
    
    @Inject
    UserRepository userRepo;
    
    @Override
    public void filter(ContainerRequestContext requestContext) {
        LOG.debug("AuthFilter process...");
        String authValue = requestContext.getHeaderString("authorization");
         
        User user = authValue == null ? null : userRepo.findOneByHash(authValue.replace(UserSecurityContext.AUTH_SCHEMA+" ", ""));
                
        requestContext.setSecurityContext(new UserSecurityContext(new UserPrincipal(user)));
    }
    
}
