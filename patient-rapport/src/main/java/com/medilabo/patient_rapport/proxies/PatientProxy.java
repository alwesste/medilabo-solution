package com.medilabo.patient_rapport.proxies;

import com.medilabo.patient_rapport.models.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Client Feign permettant de communiquer avec le microservice des patients.
 */
@FeignClient(name = "gateway", url = "http://localhost:9003")
public interface PatientProxy {

    /**
     * Récupère les informations d’un patient à partir de son identifiant.
     *
     * @param id identifiant du patient
     * @return les informations du patient
     */
    @GetMapping(value = "/api/rapport/patient/detail/{id}")
    PatientDTO getPatient(@PathVariable Long id);

}
