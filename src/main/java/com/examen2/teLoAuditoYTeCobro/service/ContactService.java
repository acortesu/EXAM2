package com.examen2.teLoAuditoYTeCobro.service;

import com.examen2.teLoAuditoYTeCobro.domain.Contact;
import com.examen2.teLoAuditoYTeCobro.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

        @Autowired
        ContactRepository contactRepository;

        public void saveContact(Contact contact) {
            contactRepository.save(contact);
        }

        public List<Contact> getAll() {
            return contactRepository.findAll();
        }

        public Optional<Contact> getById(int id) {
            return contactRepository.findById(Long.valueOf(id));
        }

        public void updateContact(Contact contact) {
            contactRepository.save(contact);
        }

        public void deleteContact(int id) {
            contactRepository.deleteById(Long.valueOf(id));
        }


}
