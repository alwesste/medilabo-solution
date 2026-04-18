package com.medilabo.patient.DAO;

import com.medilabo.patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface PatientDAO extends JpaRepository<Patient, Long> {

    @Query("SELECT COUNT(p) > 0 FROM Patient p WHERE p.nom = :nom AND p.prenom = :prenom AND p.birthDate = :birthDate")
    boolean existsPatient(@Param("nom") String nom,
                          @Param("prenom") String prenom,
                          @Param("birthDate") LocalDate birthDate);
}
