package com.appdev.phishers.arongg4.Controller;

import com.appdev.phishers.arongg4.Entity.TagEntity;
import com.appdev.phishers.arongg4.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController{
    
    @Autowired
    TagService tServ;

    @PostMapping("/post")
    public TagEntity postTag(@RequestBody TagEntity tag){
        return tServ.postTag(tag);
    }

    @GetMapping("/getAll")
    public List<TagEntity> getAllTags(){
        return tServ.getAllTags();
    }

    @PutMapping("/update/{tagId}")
    public TagEntity updateTag(@PathVariable int tagId, @RequestBody TagEntity tag){
        return tServ.updateTag(tagId, tag);
    }

    @DeleteMapping("/delete/{tagId}")
    public String deleteTag(@PathVariable int tagId){
        return tServ.deleteTag(tagId);
    }
}
