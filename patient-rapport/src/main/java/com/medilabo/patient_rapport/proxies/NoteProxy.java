package com.medilabo.patient_rapport.proxies;

import com.medilabo.patient_rapport.models.NoteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Client Feign permettant de communiquer avec le microservice des notes
 */
@FeignClient(name = "gateway-note", url = "${gateway.url}")
public interface NoteProxy {

    /**
     * Récupère les notes associées à un patient.
     * @param id identifiant du patient
     * @return la liste des notes du patient
     */
    @GetMapping("/api/note/{id}")
    public List<NoteDTO> getNotesByPatient(@PathVariable Long id);
}
