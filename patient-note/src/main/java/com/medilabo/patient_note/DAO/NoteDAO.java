package com.medilabo.patient_note.DAO;

import com.medilabo.patient_note.models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteDAO extends MongoRepository<Note, String> {

    List<Note> findByPatId(Long patId);
}
