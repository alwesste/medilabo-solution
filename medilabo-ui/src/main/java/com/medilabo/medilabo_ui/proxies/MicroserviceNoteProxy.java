package com.medilabo.medilabo_ui.proxies;

import com.medilabo.medilabo_ui.models.NoteBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "gateway-note", url = "http://localhost:9003")
public interface MicroserviceNoteProxy {

    @GetMapping(value = "/api/note/{id}")
    List<NoteBean> getNoteByPatientId(@PathVariable Long id);

    @PostMapping("/api/add/note")
    void addNote(@RequestBody NoteBean noteBean);

}
