package com.medilabo.patient_note.services.impl;

import com.medilabo.patient_note.DAO.NoteDAO;
import com.medilabo.patient_note.models.Note;
import com.medilabo.patient_note.services.INoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NoteService implements INoteService {

    private final NoteDAO noteDAO;

    public NoteService(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    public List<Note> getNotesByPatient(Long patId) {
        return noteDAO.findByPatId(patId);
    }

    public void addNote(Note note) {
        if (note == null) {
            throw new IllegalArgumentException("Le note ne peut pas être null");
        }
        noteDAO.save(note);
    }

    public void deleteNote(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("L'id de la note ne peut pas être null");
        }
        if (!noteDAO.existsById(id)) {
            throw new NoSuchElementException("Note introuvable pour l'id : " + id);
        }
        noteDAO.deleteById(id);
    }
}
