package com.appdev.phishers.arongg4.Entity;

import jakarta.persistence.*;

@Entity
public class TagEntity{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tag_id;

    private String tagName;

    public TagEntity(){
        super();
    }

    public TagEntity(int tag_id, String tagName){
        super();
        this.tag_id = tag_id;
        this.tagName = tagName;
    }

    
    public int getTag_id(){
        return tag_id;
    }

    public void setTag_id(int tag_id){
        this.tag_id = tag_id;
    }

    public String getTagName(){
        return tagName;
    }

    public void setTagName(String tagName){
        this.tagName = tagName;
    }
}
