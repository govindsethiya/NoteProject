package com.springboot.restAPI.note.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restAPI.note.model.Note;
import com.springboot.restAPI.note.repository.NoteRepository;

@Service
public class NoteService {

	@Autowired
	private NoteRepository noteRepository;

	public List<Note> getAllNote() {
		List<Note> Notes = new ArrayList<>();
		noteRepository.findAll().forEach(Notes::add);
		return Notes;
	}

	public Note getNote(String id) {
		return noteRepository.findOne(id);
	}

	public void createOrUpdateNote(Note Note) {
		noteRepository.save(Note);

	}

	public void deleteNote(String id) {
		noteRepository.delete(id);
	}

}
