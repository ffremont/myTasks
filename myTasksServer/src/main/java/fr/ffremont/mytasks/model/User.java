/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ffremont.mytasks.model;

import fr.ffremont.mytasks.rest.TimeStampAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author florent
 */
@CompoundIndexes({
        @CompoundIndex(name = "users_email_unique",
                       unique = true,
                       def = "{'email' : 1}")
})
@Document(collection = "users")
public class User {
    @Id
    private String id;
    
    private String nickname;
    
    private String firstname;
    
    private String lastname;
    
    private String hash;
    
    private String email;
    
    @XmlJavaTypeAdapter(TimeStampAdapter.class)
    private Date lastConnexion;
    
    private String role;
    
    private List<TagLight> subscribeTags;

    public User() {
        this.subscribeTags = new ArrayList();
        this.role = Role.USER;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastConnexion() {
        return lastConnexion;
    }

    public void setLastConnexion(Date lastConnexion) {
        this.lastConnexion = lastConnexion;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<TagLight> getSubscribeTags() {
        return subscribeTags;
    }

    public void setSubscribeTags(List<TagLight> subscribeTags) {
        this.subscribeTags = subscribeTags;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
