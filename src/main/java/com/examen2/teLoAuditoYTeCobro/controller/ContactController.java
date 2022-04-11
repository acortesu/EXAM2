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

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {

    @Autowired
    ContactService contactService;
    @Autowired
    ClientService clientService;

   @RequestMapping(value = "/listContacts")
    public String contactList(Model model){
        List<Contact> results = contactService.getAll();
        model.addAttribute("contact", contactService.getAll());
        return "listContacts";
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.GET)
    public String contactListPage(Model model){
        List<Client> clientList = clientService.getAll();
        model.addAttribute("clientsAll", clientList);
        model.addAttribute(new Contact());
        return "addContact";
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String addContactPage(Contact contact, BindingResult result, Model model){
        contactService.saveContact(contact);
        return "success";
    }

    @RequestMapping(value = "/editContact/{id}")
    public String editContact(Model model, @PathVariable int id) {
        List<Client> clientList = clientService.getAll();
        model.addAttribute("clientsAll", clientList);
        Optional<Contact> contactToEdit = contactService.getById(id);
        if (contactToEdit.isPresent()){
            model.addAttribute("contactToEdit", contactToEdit);
            return "editContact";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/editContact/{id}", method = RequestMethod.POST)
    public String saveChangesContact(Contact contact, BindingResult result, Model model, @PathVariable int id) {
        contactService.updateContact(contact);
        return "success";

    }

    @RequestMapping(value = "/deleteContact/{id}")
    public String deleteContact(Model model, @PathVariable int id) {
        contactService.deleteContact(id);
        return "success";

    }
}
