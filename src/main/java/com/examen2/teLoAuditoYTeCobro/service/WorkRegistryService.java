package com.examen2.teLoAuditoYTeCobro.service;


import com.examen2.teLoAuditoYTeCobro.domain.WorkRegistry;
import com.examen2.teLoAuditoYTeCobro.repository.WorkRegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkRegistryService {

    @Autowired
    WorkRegistryRepository workRegistryRepository;

    public void saveWorkRegistry(WorkRegistry workRegistry) {workRegistryRepository.save(workRegistry);}

    public List<WorkRegistry> getAll() {
        return workRegistryRepository.findAll();
    }

    public Optional<WorkRegistry> getById(int id) {
        return workRegistryRepository.findById(Long.valueOf(id));
    }

    public void updateWorkRegistry(WorkRegistry workRegistry) {
        workRegistryRepository.save(workRegistry);
    }

}
