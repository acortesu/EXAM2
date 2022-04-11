package com.examen2.teLoAuditoYTeCobro.repository;

import com.examen2.teLoAuditoYTeCobro.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientByName(String name);
}
