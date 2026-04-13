package com.medilabo.medilabo_ui.proxies;

import com.medilabo.medilabo_ui.models.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "patient")
public interface MicroservicePatientProxy {

    @GetMapping(value = "/api/patient")
    List<PatientBean> checkAllPatients();
}
