package com.medilabo.patient_rapport.models;

public record Note(String id, Long patId, String patient, String note) {}
