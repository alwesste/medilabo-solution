package com.medilabo.patient.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medecin")
public class Medecin extends Person {
    private String specialite;

    public String getSpecialite() {
        return specialite;
    }

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Patient> patients;


    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

}
