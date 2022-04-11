package com.examen2.teLoAuditoYTeCobro.repository;

import com.examen2.teLoAuditoYTeCobro.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
