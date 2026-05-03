package com.medilabo.patient_note.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "note")
public class Note {

    @Id
    private String id;

    @Field("patId")
    private Long patId;

    @Field("patient")
    private String patient;

    @Field("note")
    private String note;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public Long getPatId() { return patId; }

    public void setPatId(Long patId) { this.patId = patId; }

    public String getPatient() { return patient; }

    public void setPatient(String patient) { this.patient = patient; }

    public String getNote() { return note; }

    public void setNote(String note) { this.note = note; }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", patId=" + patId +
                ", patient='" + patient + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
