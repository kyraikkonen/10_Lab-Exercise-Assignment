package com.appdev.phishers.arongg4.Controller;

import com.appdev.phishers.arongg4.Entity.NoteEntity;
import com.appdev.phishers.arongg4.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController{

    @Autowired
    NoteService nServ;

    @PostMapping("/post")
    public NoteEntity postNote(@RequestBody NoteEntity note){
        return nServ.postNote(note);
    }

    @GetMapping("/getAll")
    public List<NoteEntity> getAllNotes(){
        return nServ.getAllNotes();
    }

    @PutMapping("/update/{noteId}")
    public NoteEntity updateNote(@PathVariable int noteId, @RequestBody NoteEntity note){
        return nServ.updateNote(noteId, note);
    }

    @DeleteMapping("/delete/{noteId}")
    public String deleteNote(@PathVariable int noteId){
        return nServ.deleteNote(noteId);
    }
}
