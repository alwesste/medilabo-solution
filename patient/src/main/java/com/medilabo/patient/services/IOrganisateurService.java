package com.medilabo.patient.services;

import com.medilabo.patient.entities.Patient;

import java.util.List;

public interface IOrganisateurService {
    Patient updatePatient(Patient patient);
    Patient addPatient(Patient patient);
    List<Patient> getAllPatients();
}
