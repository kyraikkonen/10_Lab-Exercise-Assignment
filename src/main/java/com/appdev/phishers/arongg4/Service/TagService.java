package com.appdev.phishers.arongg4.Service;

import com.appdev.phishers.arongg4.Entity.TagEntity;
import com.appdev.phishers.arongg4.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TagService{

    @Autowired
    TagRepository tRepo;

    public TagEntity postTag(TagEntity tag){
        return tRepo.save(tag);
    }

    
    public List<TagEntity> getAllTags(){
        return tRepo.findAll();
    }

    public TagEntity updateTag(int tagId, TagEntity updatedTagDetails){
        Optional<TagEntity> optionalTag = tRepo.findById(tagId);

        if(optionalTag.isPresent()){
            TagEntity existingTag = optionalTag.get();
            existingTag.setTagName(updatedTagDetails.getTagName());

            return tRepo.save(existingTag);
        }
        return null; 
    }
    
    public String deleteTag(int tagId){
        if(tRepo.existsById(tagId)){
            tRepo.deleteById(tagId);
            return "Tag with ID " + tagId + " deleted successfully.";
        }
        return "Tag with ID " + tagId + " not found.";
    }
}