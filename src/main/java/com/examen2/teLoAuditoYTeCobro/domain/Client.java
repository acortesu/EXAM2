package com.examen2.teLoAuditoYTeCobro.domain;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, legalId, adress, phoneNumber;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTACT_ID", referencedColumnName = "ID")
    private List<Contact> contacts;

    public Client(Long id, String name, String legalId, String adress, String phoneNumber, List<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.legalId = legalId;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.contacts = contacts;
    }

    public Client() {
    }

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

    public String getLegalId() {
        return legalId;
    }

    public void setLegalId(String legalId) {
        this.legalId = legalId;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder("ClienteEntry(");
        value.append("Id: ");
        value.append(id);
        value.append(",Name: ");
        value.append(name);
        value.append(",Legal Id: ");
        value.append(legalId);
        value.append(",Adress: ");
        value.append(adress);
        value.append(",Phone Number: ");
        value.append(phoneNumber);
        value.append(")");
        return value.toString();
    }
}
