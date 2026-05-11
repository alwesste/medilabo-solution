package com.medilabo.patient_rapport.models;

import java.time.LocalDate;

public record PatientDTO(
        Gender genre,
        LocalDate birthDate) {}
