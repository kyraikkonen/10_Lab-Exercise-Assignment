package com.appdev.phishers.arongg4.Service;

import com.appdev.phishers.arongg4.Entity.NoteEntity;
import com.appdev.phishers.arongg4.Entity.TagEntity;
import com.appdev.phishers.arongg4.Repository.NoteRepository;
import com.appdev.phishers.arongg4.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class NoteService{

    @Autowired
    NoteRepository nRepo;

    @Autowired
    TagRepository tRepo;

    public NoteEntity postNote(NoteEntity note){
        if(note.getTags() != null && !note.getTags().isEmpty()){
            Set<TagEntity> fullTags = new HashSet<>();
            for(TagEntity tagFromRequest : note.getTags()){
                Optional<TagEntity> fullTag = tRepo.findById(tagFromRequest.getTag_id());
                if(fullTag.isPresent()){
                    fullTags.add(fullTag.get());
                }
            }
            note.setTags(fullTags);
        }
        return nRepo.save(note);
    }

    public List<NoteEntity> getAllNotes(){
        return nRepo.findAll();
    }

    public NoteEntity updateNote(int noteId, NoteEntity updatedNote){
        Optional<NoteEntity> optionalNote = nRepo.findById(noteId);

        if(optionalNote.isPresent()){
            NoteEntity existingNote = optionalNote.get();
            existingNote.setTitle(updatedNote.getTitle());
            existingNote.setContent(updatedNote.getContent());
            existingNote.setTags(updatedNote.getTags());
            existingNote.setDateUpdated(new Date());

            if(updatedNote.getTags() != null && !updatedNote.getTags().isEmpty()){
                Set<TagEntity> fullTags = new HashSet<>();
                for(TagEntity tagFromRequest : updatedNote.getTags()){
                    Optional<TagEntity> fullTag = tRepo.findById(tagFromRequest.getTag_id());
                    if(fullTag.isPresent()){
                        fullTags.add(fullTag.get());
                    }
                }
                existingNote.setTags(fullTags);
            } else{
                existingNote.setTags(new HashSet<>());
            }
            return nRepo.save(existingNote);
        }
        return null; 
    }

    public String deleteNote(int noteId){
        if(nRepo.existsById(noteId)){
            nRepo.deleteById(noteId);
            return "Note with ID " + noteId + " deleted successfully.";
        }
        return "Note with ID " + noteId + " not found.";
    }
}
