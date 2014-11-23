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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author florent
 */
@Document(collection = "users")
public class User {
    @Id
    private String id;
    
    private String name;
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
