package com.examen2.teLoAuditoYTeCobro.repository;

import com.examen2.teLoAuditoYTeCobro.domain.Auditor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditorRepository extends JpaRepository<Auditor, Long> {
    Auditor findAuditorByName(String name);
}
