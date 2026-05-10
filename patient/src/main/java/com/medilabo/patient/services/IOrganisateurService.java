package com.medilabo.patient.services;

import com.medilabo.patient.entities.Patient;

import java.util.List;
import java.util.Optional;

/**
 * Interface définissant les services de gestion des patients.
 */
public interface IOrganisateurService {

    /**
     * Récupère un patient à partir de son identifiant.
     * @param id identifiant du patient
     * @return un Optional contenant le patient s’il existe
     */
    Optional<Patient> getPatientById(Long id);

    /**
     * Récupère la liste de tous les patients.
     * @return la liste des patients
     */
    List<Patient> getAllPatients();

    /**
     * Met à jour les informations d’un patient.
     * @param patient patient à mettre à jour
     * @return le patient mis à jour
     */
    Patient updatePatient(Patient patient);

    /**
     * Ajoute un nouveau patient.
     * @param patient patient à ajouter
     * @return le patient enregistré
     */
    Patient addPatient(Patient patient);
}
