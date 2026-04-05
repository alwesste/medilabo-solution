package com.medilabo.patient.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "patient")
public class Patient extends Person {
    private Date birthDate;
    private String genre;
    private String adressePostal;
    private String phoneNumber;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAdressePostal() {
        return adressePostal;
    }

    public void setAdressePostal(String adressePostal) {
        this.adressePostal = adressePostal;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void checkHistoric() {
        System.out.println("Voir historique");
    }

    public void addNote() {
        System.out.println("Voir note");
    }

    public void generalReport() {
        System.out.println("generateReport");
    }
}
