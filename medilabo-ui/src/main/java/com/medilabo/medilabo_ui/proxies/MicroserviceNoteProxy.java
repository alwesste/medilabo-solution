package com.medilabo.medilabo_ui.proxies;

import com.medilabo.medilabo_ui.models.NoteBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "gateway-note", url = "http://localhost:9003")
public interface MicroserviceNoteProxy {

    @GetMapping(value = "/api/note/{id}")
    String getNoteByPatientId(@PathVariable Long id);


}
