package com.medilabo.patient_note.DAO;

import com.medilabo.patient_note.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface NoteDAO extends MongoRepository<Note, String> {

    Optional<Note> findByPatientId(Long patientId);

}
