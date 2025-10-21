package com.appdev.phishers.arongg4.Entity;

import com.appdev.phishers.arongg4.Entity.TagEntity;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity 
public class NoteEntity{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int note_id;

    private String title;
    private String content;

    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Temporal(TemporalType.DATE)
    private Date dateUpdated;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "note_tag_junction",
        joinColumns = @JoinColumn(name = "note_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<TagEntity> tags; 

 
    public NoteEntity() {
        super();
        this.dateCreated = new Date(); 
    }

    public int getNote_id() {
        return note_id;
    }
    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Date getDateUpdated() {
        return dateUpdated;
    }
    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
    public Set<TagEntity> getTags() {
        return tags;
    }
    public void setTags(Set<TagEntity> tags) {
        this.tags = tags;
    }
}
