package com.examen2.teLoAuditoYTeCobro.repository;

import com.examen2.teLoAuditoYTeCobro.domain.WorkRegistry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRegistryRepository extends JpaRepository<WorkRegistry, Long> {
    WorkRegistry findWorkRegistryById(String id);
}
