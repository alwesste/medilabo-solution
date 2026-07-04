package com.medilabo.patient_rapport.services;

import com.medilabo.patient_rapport.models.RisqueLevel;

/**
 * Interface definissant les methodes pour l'écriture des rapports en fonction des notes de medecins
 */
public interface IRapportService {

    /**
     * Calcule le niveau de risque d'un patient.
     *
     * @param patientId identifiant du patient
     * @return le niveau de risque
     */
    RisqueLevel getRapportWithRisqueLevel(Long patientId);

    /**
     * Compte le nombre de déclencheurs de diabète présents dans les notes médicales d'un patient.
     *
     * @param patientId l'identifiant du patient
     * @return le nombre de déclencheurs trouvés
     */
    long getNumberOfDelencheurByPatient(Long patientId);
}