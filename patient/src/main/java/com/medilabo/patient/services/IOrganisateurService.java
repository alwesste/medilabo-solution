package com.medilabo.patient.services;

import com.medilabo.patient.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface IOrganisateurService {
    Optional<Patient> getPatientById(Long id);
    List<Patient> getAllPatients();
    Patient updatePatient(Patient patient);
    Patient addPatient(Patient patient);
}
