/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ffremont.mytasks.model;

import fr.ffremont.mytasks.rest.TimeStampAdapter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author florent
 */
@Document(collection = "tasks")
public class Task {
    @Id
    private String id;
    
    private int number;
    
    @XmlJavaTypeAdapter(TimeStampAdapter.class)
    private Date created;
    
    @XmlJavaTypeAdapter(TimeStampAdapter.class)
    private Date updated;
    
    private String author;
    
    @XmlJavaTypeAdapter(TimeStampAdapter.class)
    private Date deadLine;
    
    private Assignment assigned;
    
    private List<Assignment> assignments;
    
    private long duration;
    
    private String subject;
    
    private String content;
    
    private List<TagLight> tags;
    
    private boolean isRemoved;
    
    private List<Message> messages;

    public Task() {
        this.created = new Date();
        this.messages = new ArrayList();
        this.tags = new ArrayList();
        this.assignments = new ArrayList();
        this.isRemoved = false;        
        
        this.subject = "";
        this.content = "";
    }
    
    public Task(String author){
        this();
        
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Assignment getAssigned() {
        return assigned;
    }

    public void setAssigned(Assignment assigned) {
        this.assigned = assigned;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<TagLight> getTags() {
        return tags;
    }

    public void setTags(List<TagLight> tags) {
        this.tags = tags;
    }

    public boolean isIsRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    
}
