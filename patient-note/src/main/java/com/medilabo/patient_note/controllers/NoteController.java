package com.medilabo.patient_note.controllers;

import com.medilabo.patient_note.model.Note;
import com.medilabo.patient_note.services.impl.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/api/note/{id}")
    List<Note> getNote(@PathVariable Long id) {
        logger.info("Id recupere depuis l'ui: {}", id);
        return noteService.getNotesByPatient(id);
    }

    @PostMapping("/api/note/add")
    public ResponseEntity<String> addNote(@RequestBody Note note) {
        if (note.getNote() == null || note.getNote().isBlank()) {
            return ResponseEntity.badRequest().body("La note ne peut pas être vide");
        }
        if (note.getPatId() == null) {
            return ResponseEntity.badRequest().body("Le patient est obligatoire");
        }
        logger.info("Note ajoutée : {}", note);
        noteService.addNote(note);
        return ResponseEntity.ok("Note ajoutée avec succès");
    }
}
