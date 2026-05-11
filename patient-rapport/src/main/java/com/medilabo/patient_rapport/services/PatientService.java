package com.medilabo.patient_rapport.services;

import com.medilabo.patient_rapport.models.PatientDTO;
import com.medilabo.patient_rapport.proxies.PatientProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);
    private final PatientProxy patientProxy;

    public PatientService(PatientProxy patientProxy) {
        this.patientProxy = patientProxy;
    }

    public PatientDTO getPatient(Long id) {
        PatientDTO patientDTO = patientProxy.getPatient(id);
        logger.info("PatientDTO reçu: gender={}, birthDate={}", patientDTO.genre(), patientDTO.birthDate());
        return patientDTO;
    }
}
