package com.medilabo.patient_rapport.controllers;

import com.medilabo.patient_rapport.models.RisqueLevel;
import com.medilabo.patient_rapport.services.RapportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controleur REST permettant de gerer les rapports des patients
 */
@RestController
public class RapportController {

    private final RapportService rapportService;

    public RapportController(RapportService rapportService) {
        this.rapportService = rapportService;
    }

    /**
     * Récupère le niveau de risque d’un patient à partir de son id
     * @param patientId identifiant du patient
     * @return le niveau de risque du patient
     */
    @GetMapping("/api/rapport/{patientId}")
    public RisqueLevel getRisqueLevelByPatientId(@PathVariable Long patientId) {
        return rapportService.getRapportWithRisqueLevel(patientId);
    }
}
