package com.medilabo.patient.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "patient", uniqueConstraints = @UniqueConstraint(columnNames = {"nom", "prenom", "birth_date"}))
public class Patient extends Person {
    @Column(name = "birth_date")
    @NotNull
    private LocalDate birthDate;
    @NotBlank
    private String genre;
    @Column(name = "adresse_postal")
    private String adressePostal;
    private String phoneNumber;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
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

    @Override
    public String toString() {
        return "Patient{" +
                "birthDate=" + birthDate +
                ", genre='" + genre + '\'' +
                ", adressePostal='" + adressePostal + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
