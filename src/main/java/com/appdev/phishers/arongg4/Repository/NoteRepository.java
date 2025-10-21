package com.appdev.phishers.arongg4.Repository;

import com.appdev.phishers.arongg4.Entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Integer>{

}
