package com.medilabo.patient_rapport.services;

import com.medilabo.patient_rapport.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RapportService {

    private static final Logger logger = LoggerFactory.getLogger(RapportService.class);
    private final NoteService noteService;
    private final PatientService patientService;

    public RapportService(NoteService noteService, PatientService patientService) {
        this.noteService = noteService;
        this.patientService = patientService;
    }


    public RisqueLevel getRapportWithRisqueLevel(Long patientId) {
        Long declencheurNumber = getNumberOfDelencheurByPatient(patientId);
        PatientDTO patientDTODetail = patientService.getPatient(patientId);
        Gender patientGender = patientDTODetail.genre();
        int patientAge = Period.between(patientDTODetail.birthDate(), LocalDate.now()).getYears();
        logger.info("Nombre de declencheur: {} age de la personne : {} gender: {}", declencheurNumber, patientAge, patientGender);


        if (declencheurNumber == 0) {
            return RisqueLevel.NONE;
        }

        if (patientAge < 30) {
            if (patientGender == Gender.M && declencheurNumber >= 5) {
                return RisqueLevel.EARLY_ONSET;
            }
            if (patientGender == Gender.F && declencheurNumber >= 7) {
                return RisqueLevel.EARLY_ONSET;
            }
        } else {
            if (declencheurNumber >= 8) {
                return RisqueLevel.EARLY_ONSET;
            }
        }

        if (patientAge < 30) {
            if (patientGender == Gender.M && declencheurNumber >= 3) {
                return RisqueLevel.DANGER;
            }
            if (patientGender == Gender.F && declencheurNumber >= 4) {
                return RisqueLevel.DANGER;
            }
        } else {
            if (declencheurNumber >= 6 && declencheurNumber <= 7) {
                return RisqueLevel.DANGER;
            }
        }

        if (patientAge > 30 && declencheurNumber >= 2 && declencheurNumber <= 5) {
            return RisqueLevel.BORDERLINE;
        }

        return RisqueLevel.NONE;
    }


    private long getNumberOfDelencheurByPatient(Long patientId) {
        List<NoteDTO> noteDTOS = noteService.getNotesByPatientId(patientId);
        String notesContent = noteDTOS.stream().map(NoteDTO::note).collect(Collectors.joining(" "));
        String lowerNoteContent = notesContent.toLowerCase();
        long numberOfDeclencheur = Arrays.stream(Declencheur.values()).filter(declencheur -> lowerNoteContent.contains(declencheur.getLibelle())).count();
        return numberOfDeclencheur;
    }


}
