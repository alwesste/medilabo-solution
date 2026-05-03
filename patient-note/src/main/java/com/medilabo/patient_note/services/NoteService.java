package com.medilabo.patient_note.services;

import com.medilabo.patient_note.DAO.NoteDAO;
import com.medilabo.patient_note.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteDAO noteDAO;

    public NoteService(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    public List<Note> getNoteByPatient(Long patId) {
        return noteDAO.findByPatId(patId);
    }

    public void addNote(Note note) {
        noteDAO.save(note);
    }
}
