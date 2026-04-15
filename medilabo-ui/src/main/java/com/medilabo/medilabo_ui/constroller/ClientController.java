package com.medilabo.medilabo_ui.constroller;

import com.medilabo.medilabo_ui.models.PatientBean;
import com.medilabo.medilabo_ui.proxies.MicroservicePatientProxy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class ClientController {

    private final MicroservicePatientProxy microservicePatientProxy;

    public ClientController(MicroservicePatientProxy microservicePatientProxy) {
        this.microservicePatientProxy = microservicePatientProxy;
    }

    @GetMapping
    public List<PatientBean> getAllPatients() {
        return microservicePatientProxy.checkAllPatients();
    }

    @PatchMapping
    public PatientBean updatePatient(@RequestBody PatientBean patientBean) {
        return microservicePatientProxy.updatePatient(patientBean);
    }

    @PostMapping
    public PatientBean addPatient(@RequestBody PatientBean patientBean) {
        return microservicePatientProxy.addPatient(patientBean);
    }

}
