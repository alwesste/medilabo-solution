package com.medilabo.medilabo_ui.proxies;

import com.medilabo.medilabo_ui.models.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "gateway", url = "http://localhost:9003")
public interface MicroservicePatientProxy {

    @GetMapping(value = "/api/patient/detail/{id}")
    PatientBean getPatient(@PathVariable Long id);

    @GetMapping(value = "/api/patients")
    List<PatientBean> checkAllPatients();

    @PutMapping(value = "/api/patient")
    PatientBean updatePatient(@RequestBody PatientBean patientBean);

    @PostMapping(value = "/api/patient")
    PatientBean addPatient(@RequestBody PatientBean patientBean);
}
