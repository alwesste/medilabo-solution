package com.medilabo.patient.controllers;

import com.medilabo.patient.entities.Patient;
import com.medilabo.patient.services.impl.OrganisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganisateurController {

    private final OrganisateurService organisateurService;

    public OrganisateurController(OrganisateurService organisateurService) {
        this.organisateurService = organisateurService;
    }

    @GetMapping("/api/patients")
    public List<Patient> checkAllPatients() {
        return organisateurService.getAllPatients();
    }

    @GetMapping("/api/patient/detail/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id) {
        return organisateurService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/api/patient")
    public Patient updatePatient(@RequestBody Patient patient) {
        return organisateurService.updatePatient(patient);
    }

    @PostMapping("/api/patient")
    public Patient addPatient(@RequestBody Patient patient) {
        return organisateurService.addPatient(patient);
    }
}
