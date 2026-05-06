package com.medilabo.patient_note.services;

import com.medilabo.patient_note.model.Note;

import java.util.List;

public interface INoteService {

    List<Note> getNoteByPatient(Long patId);
    void addNote(Note note);
}
