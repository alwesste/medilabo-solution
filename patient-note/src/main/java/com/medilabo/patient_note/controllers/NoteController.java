package com.medilabo.patient_note.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @GetMapping("/api/note/{id}")
    String getNote(@PathVariable Long id) {
        return "id" + "de l objet";
    }
}
