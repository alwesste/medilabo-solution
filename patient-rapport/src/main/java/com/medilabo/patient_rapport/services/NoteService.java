package com.medilabo.patient_rapport.services;

import com.medilabo.patient_rapport.models.Note;
import com.medilabo.patient_rapport.proxies.NoteProxy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteProxy noteProxy;

    public NoteService(NoteProxy noteProxy) {
        this.noteProxy = noteProxy;
    }

    public List<Note> getNotesByPatientId(Long id) {
        return noteProxy.getNotesByPatient(id);
    }
}
