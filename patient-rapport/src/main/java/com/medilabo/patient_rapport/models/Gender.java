package com.medilabo.patient_rapport.models;

public enum Gender {
    M("HOMME"),
    F("FEMME");

    private final String libelle;

    Gender(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
