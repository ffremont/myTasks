/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ffremont.mytasks.security;

import java.security.Principal;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author florent
 */
public class UserSecurityContext implements SecurityContext{

    public final static String AUTH_SCHEMA = "HASH";
    
    private UserPrincipal user;
    
    public UserSecurityContext(UserPrincipal user){
        this.user = user;
    }
    
    @Override
    public Principal getUserPrincipal() {
        return this.user;
    }

    @Override
    public boolean isUserInRole(String role) {
        return (this.user == null) || (this.user.getCurrentUser() == null) ? false : this.user.getCurrentUser().getRole().equals(role);
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public String getAuthenticationScheme() {
        return AUTH_SCHEMA;
    }
    
}
