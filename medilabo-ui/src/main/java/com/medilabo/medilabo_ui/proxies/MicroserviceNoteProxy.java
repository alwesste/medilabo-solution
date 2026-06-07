package com.medilabo.medilabo_ui.proxies;

import com.medilabo.medilabo_ui.models.NoteBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Client Feign permettant de communiquer avec le microservice des notes
 */
@FeignClient(name = "gateway-note", url = "${gateway.url}")
public interface MicroserviceNoteProxy {

    /**
     * Récupère les notes associées à un patient.
     * @param id identifiant du patient
     * @return la liste des notes du patient
     */
    @GetMapping(value = "/api/note/{id}")
    List<NoteBean> getNoteByPatientId(@PathVariable Long id);

    /**
     * Ajoute une nouvelle note.
     * @param noteBean la note à enregistrer
     */
    @PostMapping("/api/note/add")
    void addNote(@RequestBody NoteBean noteBean);

}
