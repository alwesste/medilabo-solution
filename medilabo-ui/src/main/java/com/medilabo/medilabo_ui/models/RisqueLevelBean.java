package com.medilabo.medilabo_ui.models;

public enum RisqueLevelBean {
    NONE("Aucun risque"),
    BORDERLINE("Risque limite"),
    DANGER("Danger"),
    EARLY_ONSET("Apparition précoce");

    private final String label;

    RisqueLevelBean(String label) {
        this.label = label;
    }

    public String getLabel() { return label; }
}