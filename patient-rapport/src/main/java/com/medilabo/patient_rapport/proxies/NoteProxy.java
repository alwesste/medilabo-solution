package com.medilabo.patient_rapport.proxies;

import com.medilabo.patient_rapport.models.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "patient-note")
public interface NoteProxy {

    @GetMapping("/api/note/{id}")
    public List<Note> getNotesByPatient(@PathVariable Long id);
}
