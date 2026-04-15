package com.medilabo.medilabo_ui.proxies;

import com.medilabo.medilabo_ui.models.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "patient")
public interface MicroservicePatientProxy {

    @GetMapping(value = "/api/patient")
    List<PatientBean> checkAllPatients();

    @PatchMapping(value = "/api/patient")
    PatientBean updatePatient(PatientBean patientBean);

    @PostMapping(value = "/api/patient")
    PatientBean addPatient(PatientBean patientBean);
}
