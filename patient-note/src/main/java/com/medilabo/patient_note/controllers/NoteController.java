package com.medilabo.patient_note.controllers;

import com.medilabo.patient_note.models.Note;
import com.medilabo.patient_note.services.impl.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Controleur REST permettant de gerer les notes des médecins concernant les patients
 */
@RestController
public class NoteController {
    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    /**
     * Récupère les notes associées à un patient.
     * @param id identifiant du patient
     * @return la liste des notes du patient
     */
    @GetMapping("/api/note/{id}")
    List<Note> getNote(@PathVariable Long id) {
        logger.info("Id recupere depuis l'ui: {}", id);
        return noteService.getNotesByPatient(id);
    }


    /**
     * Ajoute une nouvelle note médicale.
     * @param note note à ajouter
     * @return une réponse indiquant le résultat de l’opération
     */
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

    /**
     * Supprime une note existante.
     * @param id identifiant de la note à supprimer
     * @return une réponse indiquant le résultat de l'opération
     */
    @DeleteMapping("/api/note/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable String id) {
        try {
            noteService.deleteNote(id);
            logger.info("Note supprimée : {}", id);
            return ResponseEntity.ok("Note supprimée avec succès");
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
