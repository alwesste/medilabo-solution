package com.medilabo.patient.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "organisateur")
public class Organisateur extends Person{

    private Patient updatePatient() {
        Patient patient = null;
        System.out.println("Patient updateted" + patient);
        return patient;
    }

    private Patient addPatient() {
        Patient patient =null;
        System.out.println("Patient updateted" + patient);
        return patient;
    }
}
