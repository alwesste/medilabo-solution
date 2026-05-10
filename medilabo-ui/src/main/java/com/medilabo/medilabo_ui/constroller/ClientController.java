package com.medilabo.medilabo_ui.constroller;

import com.medilabo.medilabo_ui.models.NoteBean;
import com.medilabo.medilabo_ui.models.PatientBean;
import com.medilabo.medilabo_ui.proxies.MicroServiceRapportProxy;
import com.medilabo.medilabo_ui.proxies.MicroserviceNoteProxy;
import com.medilabo.medilabo_ui.proxies.MicroservicePatientProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur gerant les interactions entre le client et les microservices de l'application Medilabo
 */
@Controller
public class ClientController {
    private static final Logger logger= LoggerFactory.getLogger(ClientController.class);

    private final MicroservicePatientProxy microservicePatientProxy;
    private final MicroserviceNoteProxy microserviceNoteProxy;
    private final MicroServiceRapportProxy microServiceRapportProxy;

    public ClientController(MicroservicePatientProxy microservicePatientProxy, MicroserviceNoteProxy microserviceNoteProxy, MicroServiceRapportProxy microServiceRapportProxy) {
        this.microservicePatientProxy = microservicePatientProxy;
        this.microserviceNoteProxy = microserviceNoteProxy;
        this.microServiceRapportProxy = microServiceRapportProxy;
    }

    /**
     * Affiche La liste des patients depuis la vue patientList
     * @param model
     * @return la vue patientList
     */
    @GetMapping("/patients")
    public String getAllPatients(Model model) {
        model.addAttribute("patients", microservicePatientProxy.checkAllPatients());
        return "patientList";
    }

    /**
     * Affiche le formulaire pour ajouter un nouveau patient
     * @param model
     * @return la vue patientAdd
     */
    @GetMapping("/add/patient")
    public String getAddForm(Model model) {
        model.addAttribute("patientBean", new PatientBean());
        return "patientAdd";
    }

    /**
     * Affiche les informations d'un patient en fonction de son id.
     * @param id du patient où l'on souhaite afficher les informations
     * @param model
     * @return la vue patient
     */
    @GetMapping("patient/details/{id}")
    public String getDetailPatient(@PathVariable Long id, Model model) {
        model.addAttribute("patient", microservicePatientProxy.getPatient(id));
        model.addAttribute("notes", microserviceNoteProxy.getNoteByPatientId(id));
        model.addAttribute("risqueLevel", microServiceRapportProxy.getRisqueLevelByPatientId(id));
        model.addAttribute("noteBean", new NoteBean());
        return "patient";
    }

    /**
     * Affiche le formulaire de mise à jour d'un patient.
     * @param id du patient où l'on souhaite modifier les informations
     * @param model
     * @return la vue patientUpdate
     */
    @GetMapping("/update/patient/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("patient", microservicePatientProxy.getPatient(id));
        model.addAttribute("notes", microserviceNoteProxy.getNoteByPatientId(id));
        return "patientUpdate";
    }

    /**
     * Traite la requete de mise à jour d'un patient
     * @param id
     * @param patientBean
     * @return la vue patients
     */
    @PostMapping("/update/patient/{id}")
    public String updatePatient(@PathVariable Long id,
                                @ModelAttribute PatientBean patientBean) {
        microservicePatientProxy.updatePatient(patientBean);
        return "redirect:/patients";
    }

    /**
     * Traite la requete d'envoie d'ajout de note du patient
     * @param id
     * @param noteBean
     * @param model
     * @return la vue patient
     */
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

    /**
     * Traite la requete d'ajout d'un nouveau patient
     * @param patientBean
     * @return la vue patients
     */
    @PostMapping("/add/patient")
    public String addPatient(@ModelAttribute PatientBean patientBean) {
        microservicePatientProxy.addPatient(patientBean);
        return "redirect:/patients";
    }

}
