package com.medilabo.patient_rapport.models;

public enum RisqueLevel {
    NONE("Aucun risque"),
    BORDERLINE("Risque limite"),
    DANGER("Danger"),
    EARLY_ONSET("Apparition précoce");

    private final String label;

    RisqueLevel(String label) {
        this.label = label;
    }

    public String getLabel() { return label; }
}