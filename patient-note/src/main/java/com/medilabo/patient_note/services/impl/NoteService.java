package com.medilabo.patient_note.services.impl;

import com.medilabo.patient_note.DAO.NoteDAO;
import com.medilabo.patient_note.model.Note;
import com.medilabo.patient_note.services.INoteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements INoteService {

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
