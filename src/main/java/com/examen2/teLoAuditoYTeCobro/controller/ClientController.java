package com.examen2.teLoAuditoYTeCobro.controller;

import com.examen2.teLoAuditoYTeCobro.domain.Client;
import com.examen2.teLoAuditoYTeCobro.domain.Contact;
import com.examen2.teLoAuditoYTeCobro.service.ClientService;
import com.examen2.teLoAuditoYTeCobro.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    ContactService contactService;

    @RequestMapping("/")
    public String index(Model model){
        //List<Client> results = clientService.getAll();
        //model.addAttribute("client", clientService.getAll());
        return "index";
    }

   @RequestMapping(value = "/listClients")
    public String clientList(Model model){
        List<Client> results = clientService.getAll();
        model.addAttribute("client", clientService.getAll());
        return "listClients";
    }

    @RequestMapping(value = "/addClient", method = RequestMethod.GET)
    public String clientListPage(Model model){
        List<Contact> contactList = contactService.getAll();
        model.addAttribute("contacts", contactList);
        model.addAttribute(new Client());
        return "addClient";
    }

    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public String addClientPage(Client client, BindingResult result, Model model){
        clientService.saveClient(client);
        return "success";
    }

    /*@RequestMapping(value = "/editClient/{id}")
    public String editClient(Model model, @PathVariable int id) {
        Optional<Client> clientToEdit = clientService.getById(id);
        if (clientToEdit.isPresent()){
            model.addAttribute("clientToEdit", clientToEdit);
            return "editClient";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/editClient/{id}", method = RequestMethod.POST)
    public String saveChangesClient(Client client, BindingResult result, Model model, @PathVariable int id) {
        clientService.updateClient(client);
        return "success";

    }

    @RequestMapping(value = "/deleteClient/{id}")
    public String deleteCliente(Model model, @PathVariable int id) {
        clientService.deleteClient(id);
        return "success";

    }*/

}
