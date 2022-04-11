package com.examen2.teLoAuditoYTeCobro.controller;

import com.examen2.teLoAuditoYTeCobro.domain.Auditor;
import com.examen2.teLoAuditoYTeCobro.service.AuditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class AuditorController {


    @Autowired
    AuditorService auditorService ;
    @RequestMapping("/listAuditors")
    public String listAuditors(Model model){
        List<Auditor> results = auditorService.getAll();
        model.addAttribute("auditor", auditorService.getAll());
        return "listAuditors";
    }


    @RequestMapping(value = "/addAuditor", method = RequestMethod.GET)
    public String navegarPaginaInsertar(Model model){
        model.addAttribute(new Auditor());
        return "addAuditor";
    }

    @RequestMapping(value = "/addAuditor", method = RequestMethod.POST)
    public String accionPaginaInsertar(Auditor auditor, BindingResult result, Model model){
        auditorService.saveAuditor(auditor);
        return "success";
    }

    @RequestMapping(value = "/editAuditor/{id}")
    public String irAEditar(Model model, @PathVariable int id) {
        Optional<Auditor> auditorToEdit = auditorService.getById(id);
        if (auditorToEdit.isPresent()){
            model.addAttribute("auditorToEdit", auditorToEdit);
            return "editAuditor";
        } else {
            return "notFound";
        }

    }

    @RequestMapping(value = "/editAuditor/{id}", method = RequestMethod.POST)
    public String guardarCambios(Auditor auditor, BindingResult result, Model model, @PathVariable int id) {
        auditorService.updateAuditor(auditor);
        return "success";

    }

    @RequestMapping(value = "/borrar/{id}")
    public String borrar(Model model, @PathVariable int id) {
        auditorService.deleteJournal(id);
        return "success";
    }
}
