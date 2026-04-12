package com.medilabo.patient.services.impl;

import com.medilabo.patient.services.IMedecinService;
import org.springframework.stereotype.Service;

@Service
public class MedecinService implements IMedecinService {

    @Override
    public void checkHistoric() {
        System.out.println("Voir historique du patient");
    }

    @Override
    public void addNote() {
        System.out.println("Ajouter une note");
    }

    @Override
    public void generateReport() {
        System.out.println("Générer un rapport");
    }
}
