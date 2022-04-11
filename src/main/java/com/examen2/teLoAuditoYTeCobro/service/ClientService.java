package com.examen2.teLoAuditoYTeCobro.service;

import com.examen2.teLoAuditoYTeCobro.domain.Client;
import com.examen2.teLoAuditoYTeCobro.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> getById(int id) {
        return clientRepository.findById(Long.valueOf(id));
    }

    public void updateClient(Client client) {
        clientRepository.save(client);
    }

    public void deleteClient(int id) {
        clientRepository.deleteById(Long.valueOf(id));
    }

}
