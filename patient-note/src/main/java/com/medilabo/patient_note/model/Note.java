package com.medilabo.patient_note.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Note {

    private String id;
    private Long patientId;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
