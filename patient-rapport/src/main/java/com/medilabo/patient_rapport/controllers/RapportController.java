package com.medilabo.patient_rapport.controllers;

import com.medilabo.patient_rapport.models.RisqueLevel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RapportController {

    @GetMapping("/api/rapport/{id}")
    public RisqueLevel getRisqueLevelByPatientId(@PathVariable Long id) {
        return RisqueLevel.BORDERLINE;
    }
}
