package com.appdev.phishers.arongg4.Repository;

import com.appdev.phishers.arongg4.Entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Integer> {

}
