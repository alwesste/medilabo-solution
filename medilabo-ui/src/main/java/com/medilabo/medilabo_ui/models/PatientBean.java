package com.medilabo.medilabo_ui.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class PatientBean extends PersonBean {

    @NotNull(message = "La date de naissance est obligatoire")
    private LocalDate birthDate;
    @NotBlank(message = "Le genre est obligatoire")
    private String genre;
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
        return "PatientBean{" +
                "birthDate=" + birthDate +
                ", genre='" + genre + '\'' +
                ", adressePostal='" + adressePostal + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
