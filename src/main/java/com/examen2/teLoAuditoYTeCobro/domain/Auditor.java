package com.examen2.teLoAuditoYTeCobro.domain;
import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
public class Auditor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, lastName1, lastName2, address, email;
    private int phoneNumber;
    private Date dateOfBirth = new Date();
    private String auditSpecialty;
    private Boolean travelAvailability;
    private Boolean status = true;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");


    public Auditor(Long id, String name, String lastName1, String lastName2, String address, int phoneNumber, String dateOfBirth, String email, String auditSpecialty, Boolean travelAvailability, Boolean status) throws ParseException  {
        this.id = id;
        this.name = name;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = format.parse(dateOfBirth);
        this.email = email;
        this.auditSpecialty = auditSpecialty;
        this.travelAvailability = travelAvailability;
        this.status = status;
    }
    public Auditor(Long id, String name, String lastName1, String lastName2, String address, int phoneNumber, Date dateOfBirth, String email, String auditSpecialty, Boolean travelAvailability, Boolean status) throws ParseException  {
        this.id = id;
        this.name = name;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.auditSpecialty = auditSpecialty;
        this.travelAvailability = travelAvailability;
        this.status = status;
    }

    public Auditor(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return format.format(dateOfBirth);
    }

    public void setDateOfBirth(String dateOfBirth) throws ParseException  {
        this.dateOfBirth = format.parse(dateOfBirth);
    }

    public String getAuditSpecialty() {
        return auditSpecialty;
    }

    public void setAuditSpecialty(String auditSpecialty) {
        this.auditSpecialty = auditSpecialty;
    }

    public Boolean getTravelAvailability() {
        return travelAvailability;
    }

    public void setTravelAvailability(Boolean travelAvailability) {
        this.travelAvailability = travelAvailability;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder("JournalEntry(");
        value.append("Id: ");
        value.append(id);
        value.append(",Name: ");
        value.append(name);
        value.append(",Last Name 1: ");
        value.append(lastName1);
        value.append(",Last Name 2: ");
        value.append(lastName2);
        value.append(",Address: ");
        value.append(address);
        value.append(",Phone Number: ");
        value.append(phoneNumber);
        value.append(",Date of Birth: ");
        value.append(dateOfBirth);
        value.append(",Email Address: ");
        value.append(email);
        value.append(",Audit Type: ");
        value.append(auditSpecialty);
        value.append(",Travel Availability: ");
        value.append(travelAvailability);
        value.append(")");
        return value.toString();
    }
}
