package com.examen2.teLoAuditoYTeCobro.domain;

import org.hibernate.jdbc.Work;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

@Entity
public class WorkRegistry {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date auditDate;
    private String area;
    private String name;

    public WorkRegistry(Long id, Date auditDate, String area, String name) {
        this.id = id;
        this.auditDate = auditDate;
        this.area = area;
        this.name = name;
    }

    public WorkRegistry(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        StringBuilder value = new StringBuilder("JournalEntry(");
        value.append("Id: ");
        value.append(id);
        value.append(",Name: ");
        value.append(name);
        value.append(",Area: ");
        value.append(area);
        value.append(",Audit Date: ");
        value.append(auditDate);
        value.append(")");
        return value.toString();
    }
}