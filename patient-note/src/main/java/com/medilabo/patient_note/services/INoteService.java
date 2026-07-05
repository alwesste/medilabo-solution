package com.medilabo.patient_note.services;

import com.medilabo.patient_note.models.Note;

import java.util.List;

/**
 * Interface definissant les methodes de gestions des notes des médecins
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
     * @param note à ajouter
     */
    void addNote(Note note);

    /**
     * Supprimer une note médicale.
     * @param id de la note à supprimer
     */
    void deleteNote(String id);
}
