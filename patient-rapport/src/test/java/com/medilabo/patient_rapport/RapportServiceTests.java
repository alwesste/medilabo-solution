package com.medilabo.patient_rapport;

import com.medilabo.patient_rapport.models.Gender;
import com.medilabo.patient_rapport.models.NoteDTO;
import com.medilabo.patient_rapport.models.PatientDTO;
import com.medilabo.patient_rapport.models.RisqueLevel;
import com.medilabo.patient_rapport.services.NoteService;
import com.medilabo.patient_rapport.services.PatientService;
import com.medilabo.patient_rapport.services.RapportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RapportServiceTests {

    @Mock
    private NoteService noteService;

    @Mock
    private PatientService patientService;

    @InjectMocks
    private RapportService rapportService;

    private NoteDTO note(String noteContent) {
        return new NoteDTO("1", 1L, "patient", noteContent);
    }

    // NONE
    @Test
    void shouldReturnNoneWhenNoDeclencheur() {
        when(noteService.getNotesByPatientId(1L)).thenReturn(List.of());
        when(patientService.getPatient(1L)).thenReturn(new PatientDTO(Gender.M, LocalDate.of(1980, 1, 1)));
        assertEquals(RisqueLevel.NONE, rapportService.getRapportWithRisqueLevel(1L));
    }

    // NONE
    @Test
    void shouldReturnNoneWhenOver30With1Declencheur() {
        when(noteService.getNotesByPatientId(1L)).thenReturn(List.of(note("taille")));
        when(patientService.getPatient(1L)).thenReturn(new PatientDTO(Gender.M, LocalDate.of(1980, 1, 1)));
        assertEquals(RisqueLevel.NONE, rapportService.getRapportWithRisqueLevel(1L));
    }

    // BORDERLINE
    @Test
    void shouldReturnBorderlineWhenPatientIsOver30With2Declencheurs() {
        when(noteService.getNotesByPatientId(1L)).thenReturn(List.of(note("taille poids")));
        when(patientService.getPatient(1L)).thenReturn(new PatientDTO(Gender.M, LocalDate.of(1980, 1, 1)));
        assertEquals(RisqueLevel.BORDERLINE, rapportService.getRapportWithRisqueLevel(1L));
    }

    // BORDERLINE
    @Test
    void shouldReturnBorderlinePatientIsOver30With5Declencheurs() {
        when(noteService.getNotesByPatientId(1L)).thenReturn(List.of(note("taille poids fumeur anormal cholestérol")));
        when(patientService.getPatient(1L)).thenReturn(new PatientDTO(Gender.M, LocalDate.of(1980, 1, 1)));
        assertEquals(RisqueLevel.BORDERLINE, rapportService.getRapportWithRisqueLevel(1L));
    }


    // DANGER
    @Test
    void shouldReturnDangerWhenMaleUnder30With3Declencheurs() {
        when(noteService.getNotesByPatientId(1L)).thenReturn(List.of(note("taille poids fumeur")));
        when(patientService.getPatient(1L)).thenReturn(new PatientDTO(Gender.M, LocalDate.of(2000, 6, 1)));
        assertEquals(RisqueLevel.DANGER, rapportService.getRapportWithRisqueLevel(1L));
    }

    // DANGER
    @Test
    void shouldReturnDangerWhenMaleUnder30With4Declencheurs() {
        when(noteService.getNotesByPatientId(1L)).thenReturn(List.of(note("taille poids fumeur anormal")));
        when(patientService.getPatient(1L)).thenReturn(new PatientDTO(Gender.M, LocalDate.of(2000, 6, 1)));
        assertEquals(RisqueLevel.DANGER, rapportService.getRapportWithRisqueLevel(1L));
    }

    // DANGER
    @Test
    void shouldReturnDangerWhenFemaleUnder30With4Declencheurs() {
        when(noteService.getNotesByPatientId(1L)).thenReturn(List.of(note("taille poids fumeur anormal")));
        when(patientService.getPatient(1L)).thenReturn(new PatientDTO(Gender.F, LocalDate.of(2000, 6, 1)));
        assertEquals(RisqueLevel.DANGER, rapportService.getRapportWithRisqueLevel(1L));
    }

    // DANGER
    @Test
    void shouldReturnDangerWhenFemaleUnder30With6Declencheurs() {
        when(noteService.getNotesByPatientId(1L)).thenReturn(List.of(note("taille poids fumeur anormal cholestérol vertige")));
        when(patientService.getPatient(1L)).thenReturn(new PatientDTO(Gender.F, LocalDate.of(2000, 6, 1)));
        assertEquals(RisqueLevel.DANGER, rapportService.getRapportWithRisqueLevel(1L));
    }

    // DANGER
    @Test
    void shouldReturnDangerWhenOver30With6Declencheurs() {
        when(noteService.getNotesByPatientId(1L)).thenReturn(List.of(note("taille poids fumeur anormal cholestérol vertige")));
        when(patientService.getPatient(1L)).thenReturn(new PatientDTO(Gender.M, LocalDate.of(1980, 1, 1)));
        assertEquals(RisqueLevel.DANGER, rapportService.getRapportWithRisqueLevel(1L));
    }

    // DANGER
    @Test
    void shouldReturnDangerWhenOver30With7Declencheurs() {
        when(noteService.getNotesByPatientId(1L)).thenReturn(List.of(note("taille poids fumeur anormal cholestérol vertige rechute")));
        when(patientService.getPatient(1L)).thenReturn(new PatientDTO(Gender.M, LocalDate.of(1980, 1, 1)));
        assertEquals(RisqueLevel.DANGER, rapportService.getRapportWithRisqueLevel(1L));
    }

    // EARLY ONSET
    @Test
    void shouldReturnEarlyOnsetWhenMaleUnder30With5Declencheurs() {
        when(noteService.getNotesByPatientId(1L)).thenReturn(List.of(note("taille poids fumeur anormal cholestérol")));
        when(patientService.getPatient(1L)).thenReturn(new PatientDTO(Gender.M, LocalDate.of(2000, 6, 1)));
        assertEquals(RisqueLevel.EARLY_ONSET, rapportService.getRapportWithRisqueLevel(1L));
    }

    // EARLY ONSET
    @Test
    void shouldReturnEarlyOnsetWhenFemaleUnder30With7Declencheurs() {
        when(noteService.getNotesByPatientId(1L)).thenReturn(List.of(note("taille poids fumeur anormal cholestérol vertige rechute")));
        when(patientService.getPatient(1L)).thenReturn(new PatientDTO(Gender.F, LocalDate.of(2000, 6, 1)));
        assertEquals(RisqueLevel.EARLY_ONSET, rapportService.getRapportWithRisqueLevel(1L));
    }

    // EARLY ONSET
    @Test
    void shouldReturnEarlyOnsetWhenOver30With8Declencheurs() {
        when(noteService.getNotesByPatientId(1L)).thenReturn(List.of(note("taille poids fumeur anormal cholestérol vertige rechute réaction")));
        when(patientService.getPatient(1L)).thenReturn(new PatientDTO(Gender.M, LocalDate.of(1980, 1, 1)));
        assertEquals(RisqueLevel.EARLY_ONSET, rapportService.getRapportWithRisqueLevel(1L));
    }

}
