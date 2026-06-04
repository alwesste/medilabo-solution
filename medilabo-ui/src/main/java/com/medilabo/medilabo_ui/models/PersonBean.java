package com.medilabo.medilabo_ui.models;

import jakarta.validation.constraints.NotBlank;

public class PersonBean {
    private Long id;
    @NotBlank(message = "Le prenom est obligatoire")
    private String prenom;
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
