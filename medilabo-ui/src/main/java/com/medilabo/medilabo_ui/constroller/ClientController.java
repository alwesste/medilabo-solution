package com.medilabo.medilabo_ui.constroller;

import com.medilabo.medilabo_ui.models.NoteBean;
import com.medilabo.medilabo_ui.models.PatientBean;
import com.medilabo.medilabo_ui.proxies.MicroserviceNoteProxy;
import com.medilabo.medilabo_ui.proxies.MicroservicePatientProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {
    private static final Logger logger= LoggerFactory.getLogger(ClientController.class);

    private final MicroservicePatientProxy microservicePatientProxy;

    private final MicroserviceNoteProxy microserviceNoteProxy;

    public ClientController(MicroservicePatientProxy microservicePatientProxy, MicroserviceNoteProxy microserviceNoteProxy) {
        this.microservicePatientProxy = microservicePatientProxy;
        this.microserviceNoteProxy = microserviceNoteProxy;
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
        logger.info("Objet patient : {}", microservicePatientProxy.getPatient(id) );
        model.addAttribute("patient", microservicePatientProxy.getPatient(id));
        logger.info("Objet note : {}", microserviceNoteProxy.getNoteByPatientId(id) );
        model.addAttribute("notes", microserviceNoteProxy.getNoteByPatientId(id));
        model.addAttribute("noteBean", new NoteBean());
        return "patient";
    }

    @GetMapping("/update/patient/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("patient", microservicePatientProxy.getPatient(id));
        model.addAttribute("notes", microserviceNoteProxy.getNoteByPatientId(id));
        return "patientUpdate";
    }

    @PostMapping("/update/patient/{id}")
    public String updatePatient(@PathVariable Long id,
                                @ModelAttribute PatientBean patientBean) {
        microservicePatientProxy.updatePatient(patientBean);
        return "redirect:/patients";
    }

    @PostMapping("/add/note/{id}")
    public String addNote(@PathVariable Long id, @ModelAttribute NoteBean noteBean, Model model) {
        if (noteBean.getNote() == null || noteBean.getNote().isBlank()) {
            model.addAttribute("patient", microservicePatientProxy.getPatient(id));
            model.addAttribute("notes", microserviceNoteProxy.getNoteByPatientId(id));
            model.addAttribute("noteBean", new NoteBean());
            model.addAttribute("erreur", "Veuillez saisir une note avant d'envoyer");
            return "patient";
        }
        noteBean.setId(null);
        noteBean.setPatId(id);
        microserviceNoteProxy.addNote(noteBean);
        return "redirect:/patient/details/{id}";
    }

    @PostMapping("/add/patient")
    public String addPatient(@ModelAttribute PatientBean patientBean) {
        microservicePatientProxy.addPatient(patientBean);
        return "redirect:/patients";

    }

}
