package com.medilabo.patient.services.impl;

import com.medilabo.patient.DAO.PatientDAO;
import com.medilabo.patient.entities.Patient;
import com.medilabo.patient.services.IOrganisateurService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class OrganisateurService implements IOrganisateurService {

    private final PatientDAO patientDAO;

    public OrganisateurService(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public Patient updatePatient(Patient patient) {
        Patient patientToUpdate = patientDAO.findById(patient.getId())
                .orElseThrow(() -> new EntityNotFoundException("Le patient n'a pas ete trouve" + patient.getPrenom()));

        patientToUpdate.setPrenom(patient.getPrenom());
        patientToUpdate.setNom(patient.getNom());
        patientToUpdate.setBirthDate(patient.getBirthDate());
        patientToUpdate.setGenre(patient.getGenre());
        patientToUpdate.setAdressePostal(patient.getAdressePostal());
        patientToUpdate.setPhoneNumber(patient.getPhoneNumber());

        return patientDAO.save(patientToUpdate);
    }

    @Override
    public Patient addPatient(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Le patient ne peut pas être null");
        }

        boolean exists = patientDAO.existsPatient(
                patient.getNom(),
                patient.getPrenom(),
                patient.getBirthDate()
        );

        if (exists) {
            throw new IllegalArgumentException("Un patient avec ce nom, prénom et date de naissance existe déjà");
        }
        return patientDAO.save(patient);
    }

    @Override
    public Optional<Patient> getPatientById(Long id) {
        return patientDAO.findById(id);
    }


    @Override
    public List<Patient> getAllPatients() {
        return patientDAO.findAll();
    }
}
