package com.medilabo.medilabo_ui.proxies;

import com.medilabo.medilabo_ui.models.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Client Feign permettant de communiquer avec le microservice des patients.
 */
@FeignClient(name = "gateway", url = "http://localhost:9003")
public interface MicroservicePatientProxy {

    /**
     * Récupère les informations d’un patient à partir de son identifiant.
     *
     * @param id identifiant du patient
     * @return les informations du patient
     */
    @GetMapping(value = "/api/patient/detail/{id}")
    PatientBean getPatient(@PathVariable Long id);

    /**
     * Récupère la liste de tous les patients.
     *
     * @return la liste des patients
     */
    @GetMapping(value = "/api/patients")
    List<PatientBean> checkAllPatients();

    /**
     * Met à jour les informations d’un patient.
     *
     * @param patientBean le patient à mettre à jour
     * @return le patient mis à jour
     */
    @PutMapping(value = "/api/patient")
    PatientBean updatePatient(@RequestBody PatientBean patientBean);

    /**
     * Ajoute un nouveau patient.
     *
     * @param patientBean le patient à ajouter
     * @return le patient enregistré
     */
    @PostMapping(value = "/api/patient")
    PatientBean addPatient(@RequestBody PatientBean patientBean);
}
