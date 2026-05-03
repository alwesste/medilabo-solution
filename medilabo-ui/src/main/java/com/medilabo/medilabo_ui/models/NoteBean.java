package com.medilabo.medilabo_ui.models;

public class NoteBean {

    private String id;
    private Long patId;
    private String patient;
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
        return "NoteBean{" +
                "id='" + id + '\'' +
                ", patId='" + patId + '\'' +
                ", patient='" + patient + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
