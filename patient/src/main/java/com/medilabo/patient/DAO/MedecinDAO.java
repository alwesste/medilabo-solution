package com.medilabo.patient.DAO;

import com.medilabo.patient.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinDAO extends JpaRepository<Medecin, Long> {
}
