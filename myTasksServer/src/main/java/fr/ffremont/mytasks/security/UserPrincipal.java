/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ffremont.mytasks.security;

import fr.ffremont.mytasks.model.User;
import java.security.Principal;

/**
 *
 * @author florent
 */
public class UserPrincipal implements Principal{

    private User currentUser;
    
    public UserPrincipal(User currentUser){
        this.currentUser = currentUser;
    }
    
    @Override
    public String getName() {
        return this.currentUser.getName();
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
