package com.examen2.teLoAuditoYTeCobro.domain;

import org.hibernate.jdbc.Work;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
public class WorkRegistry {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date auditDate;
    private String area;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    private Client client;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUDITOR_ID", referencedColumnName = "ID")
    private Auditor auditor;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    public WorkRegistry(Long id, String auditDate, String area, Client client, Auditor auditor) throws ParseException  {
        this.id = id;
        this.auditDate = format.parse(auditDate);
        this.area = area;
        this.client  = client;
        this.auditor = auditor;
    }

    public WorkRegistry(){}

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Auditor getAuditor() {
        return auditor;
    }

    public void setAuditor(Auditor auditor) {
        this.auditor = auditor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(String auditDate)  throws ParseException  {
        this.auditDate = format.parse(auditDate);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String toString() {
        StringBuilder value = new StringBuilder("JournalEntry(");
        value.append("Id: ");
        value.append(id);
        value.append(",Client Name: ");
        value.append(client);
        value.append(",Area: ");
        value.append(area);
        value.append(",Audit Date: ");
        value.append(auditDate);
        value.append(")");
        return value.toString();
    }
}