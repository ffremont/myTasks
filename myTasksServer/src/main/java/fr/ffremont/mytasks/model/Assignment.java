/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ffremont.mytasks.model;

import fr.ffremont.mytasks.rest.TimeStampAdapter;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author florent
 */
public class Assignment {
    private String from;
    private String to;
    
    @XmlJavaTypeAdapter(TimeStampAdapter.class)
    private Date when;

    public Assignment() {
        this.when = new Date();
    }
    
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }
    
    
}
