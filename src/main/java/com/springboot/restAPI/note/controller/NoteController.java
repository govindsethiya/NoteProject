package com.springboot.restAPI.note.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restAPI.note.model.Note;
import com.springboot.restAPI.note.service.NoteService;

@RestController
public class NoteController {

	private NoteService NoteService;

	@Autowired
	public NoteController(NoteService NoteService) {
		this.NoteService = NoteService;
	}

	// Retrieve Note by id
	@RequestMapping(value = "/note/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getNote(@PathVariable String id) {
		Note note = NoteService.getNote(id);
		if (note == null)
			return new ResponseEntity<>("Note not found.", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(note, HttpStatus.FOUND);
	}
	
	// Retrieve all the Notes 
		@RequestMapping(value = "/note", method = RequestMethod.GET)
		public List<Note> getAllNote(@PathVariable String id) {
			List<Note> allNotes = NoteService.getAllNote();
			return allNotes;
	}

	
	// create Note
	@RequestMapping(value = "/note", method = RequestMethod.POST)
	public ResponseEntity<?> createNote(@Valid @RequestBody Note note) {
		NoteService.createOrUpdateNote(note);
		return new ResponseEntity<>("Note created", HttpStatus.OK);
	}

	// update Note
	@RequestMapping(value = "/note/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateNote(@Valid @RequestBody Note Note, @PathVariable String id) {
		Note check = NoteService.getNote(id);
		if (check == null)
			return new ResponseEntity<>("Note not found.", HttpStatus.NOT_FOUND);
		Note.setId(check.getId());
		NoteService.createOrUpdateNote(Note);
		return new ResponseEntity<>("Note updated", HttpStatus.OK);
	}

	// delete Note
	@RequestMapping(value = "/note/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteNote(@PathVariable String id) {
		if (NoteService.getNote(id) == null)
			return new ResponseEntity<>("Note not found.", HttpStatus.NOT_FOUND);
		NoteService.deleteNote(id);
		return new ResponseEntity<>("Note deleted", HttpStatus.OK);
	}

}
