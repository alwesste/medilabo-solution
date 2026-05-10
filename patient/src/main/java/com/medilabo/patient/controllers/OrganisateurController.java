package com.medilabo.patient.controllers;

import com.medilabo.patient.entities.Patient;
import com.medilabo.patient.services.impl.OrganisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controleur REST permettant de gerer les patients
 */
@RestController
public class OrganisateurController {

    private final OrganisateurService organisateurService;

    public OrganisateurController(OrganisateurService organisateurService) {
        this.organisateurService = organisateurService;
    }

    /**
     * Recupere la liste de tous les patients
     * @return la liste des patients
     */
    @GetMapping("/api/patients")
    public List<Patient> checkAllPatients() {
        return organisateurService.getAllPatients();
    }

    /**
     * Recupere les informations d'un patient en fonction de son id
     * @param id
     * @return le patient correspondant
     */
    @GetMapping("/api/patient/detail/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id) {
        return organisateurService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Met a jour les informations d'un patient
     * @param patient a mettre a jour
     * @return le patient mis a jour
     */
    @PutMapping("/api/patient")
    public Patient updatePatient(@RequestBody Patient patient) {
        return organisateurService.updatePatient(patient);
    }

    /**
     * Ajoute un nouveau patient.
     * @param patient patient à ajouter
     * @return le patient enregistré
     */
    @PostMapping("/api/patient")
    public Patient addPatient(@RequestBody Patient patient) {
        return organisateurService.addPatient(patient);
    }
}
