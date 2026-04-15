package com.medilabo.patient.controllers;

import com.medilabo.patient.entities.Patient;
import com.medilabo.patient.services.impl.OrganisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class OrganisateurController {

    private final OrganisateurService organisateurService;

    public OrganisateurController(OrganisateurService organisateurService) {
        this.organisateurService = organisateurService;
    }

    @GetMapping
    public List<Patient> checkAllPatients() {
        return organisateurService.getAllPatients();
    }

    @PatchMapping
    public Patient updatePatient(@RequestBody Patient patient) {
        return organisateurService.updatePatient(patient);
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return organisateurService.addPatient(patient);
    }
}
