package com.medilabo.medilabo_ui.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class PatientBean extends PersonBean {

    @NotNull(message = "La date de naissance est obligatoire")
    @Past(message = "La date de naissance doit être dans le passé")
    private LocalDate birthDate;
    @NotBlank(message = "Le genre est obligatoire")
    private String genre;
    private String adressePostal;
    @Pattern(regexp = "^(\\d{10}|\\d{3}-\\d{3}-\\d{4})$", message = "Numéro de téléphone invalide")
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
