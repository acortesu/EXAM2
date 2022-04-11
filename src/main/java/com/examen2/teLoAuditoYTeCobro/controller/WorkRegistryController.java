package com.examen2.teLoAuditoYTeCobro.controller;

import com.examen2.teLoAuditoYTeCobro.domain.Auditor;
import com.examen2.teLoAuditoYTeCobro.domain.Client;
import com.examen2.teLoAuditoYTeCobro.domain.WorkRegistry;
import com.examen2.teLoAuditoYTeCobro.service.AuditorService;
import com.examen2.teLoAuditoYTeCobro.service.ClientService;
import com.examen2.teLoAuditoYTeCobro.service.WorkRegistryService;
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
public class WorkRegistryController {



    @Autowired
    WorkRegistryService workRegistryService;

    @Autowired
    ClientService clientService;

    @Autowired
    AuditorService auditorService;

    @RequestMapping("/listWorkRegistries")
    public String listAuditors(Model model){
        List<WorkRegistry> results = workRegistryService.getAll();
        model.addAttribute("auditor", workRegistryService.getAll());
        return "listWorkRegistries";
    }

    @RequestMapping(value = "/addWorkRegistry", method = RequestMethod.GET)
    public String navegarPaginaInsertar(Model model){
        List<Client> clientList = clientService.getAll();
        model.addAttribute("clients", clientList);
        List<Auditor> auditorList = auditorService.getAll();
        model.addAttribute("auditors", auditorList);
        model.addAttribute(new WorkRegistry());
        return "addWorkRegistry";
    }

    @RequestMapping(value = "/addWorkRegistry", method = RequestMethod.POST)
    public String accionPaginaInsertar(WorkRegistry workRegistry, BindingResult result, Model model){
        workRegistryService.saveWorkRegistry(workRegistry);
        return "success";
    }

    @RequestMapping(value = "/editWorkRegistry/{id}")
    public String irAEditar(Model model, @PathVariable int id) {
        Optional<WorkRegistry> workRegistryToEdit = workRegistryService.getById(id);
        if (workRegistryToEdit.isPresent()){
            model.addAttribute("workRegistryToEdit", workRegistryToEdit);
            return "editWorkRegistry";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/editWorkRegistry/{id}", method = RequestMethod.POST)
    public String guardarCambios(WorkRegistry workRegistry, BindingResult result, Model model, @PathVariable int id) {
        workRegistryService.updateWorkRegistry(workRegistry);
        return "success";
    }



}
