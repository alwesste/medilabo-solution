package com.medilabo.patient_rapport.controllers;

import com.medilabo.patient_rapport.models.RisqueLevel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controleur REST permettant de gerer les rapports des patients
 */
@RestController
public class RapportController {

    /**
     * Récupère le niveau de risque d’un patient à partir de son id
     * @param id identifiant du patient
     * @return le niveau de risque du patient
     */
    @GetMapping("/api/rapport/{id}")
    public RisqueLevel getRisqueLevelByPatientId(@PathVariable Long id) {
        return RisqueLevel.BORDERLINE;
    }
}
