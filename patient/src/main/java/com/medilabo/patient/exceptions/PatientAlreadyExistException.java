package com.medilabo.patient.exceptions;

public class PatientAlreadyExistException extends RuntimeException {
    public PatientAlreadyExistException(String message) {
        super(message);
    }
}
