package com.springboot.restAPI.note.repository;

import org.springframework.data.repository.CrudRepository;
import com.springboot.restAPI.note.model.Note;

public interface NoteRepository extends CrudRepository<Note, String> {


}
