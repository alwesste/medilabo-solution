package com.medilabo.medilabo_ui.constroller;

import com.medilabo.medilabo_ui.models.PatientBean;
import com.medilabo.medilabo_ui.proxies.MicroservicePatientProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    private final MicroservicePatientProxy microservicePatientProxy;

    public ClientController(MicroservicePatientProxy microservicePatientProxy) {
        this.microservicePatientProxy = microservicePatientProxy;
    }

    @GetMapping("/patients")
    public String getAllPatients(Model model) {
        model.addAttribute("patients", microservicePatientProxy.checkAllPatients());
        return "patientList";
    }

    @GetMapping("/add/patient")
    public String getAddForm(Model model) {
        model.addAttribute("patientBean", new PatientBean());
        return "patientAdd";
    }

    @GetMapping("patient/details/{id}")
    public String getDetailPatient(@PathVariable Long id, Model model) {
        model.addAttribute("patient", microservicePatientProxy.getPatient(id));
        return "patient";
    }

    @GetMapping("/update/patient/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("patient",
                microservicePatientProxy.getPatient(id));
        return "patientUpdate";
    }

    @PostMapping("/update/patient/{id}")
    public String updatePatient(@PathVariable Long id,
                                @ModelAttribute PatientBean patientBean) {
        microservicePatientProxy.updatePatient(patientBean);
        return "redirect:/patients";
    }

    @PostMapping("/add/patient")
    public String addPatient(@ModelAttribute PatientBean patientBean) {
        microservicePatientProxy.addPatient(patientBean);
        return "redirect:/patients";

    }

}
