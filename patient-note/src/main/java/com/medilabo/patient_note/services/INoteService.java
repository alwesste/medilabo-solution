package com.medilabo.patient_note.services;

import com.medilabo.patient_note.model.Note;

import java.util.List;

/**
 * Interface definissant les services de gestions des notes des medecins
 */
public interface INoteService {

    /**
     * Récupère les notes associées à un patient.
     * @param patId identifiant du patient
     * @return la liste des notes du patient
     */
    List<Note> getNotesByPatient(Long patId);

    /**
     * Ajoute une nouvelle note médicale.
     * @param note note à ajouter
     */
    void addNote(Note note);
}
