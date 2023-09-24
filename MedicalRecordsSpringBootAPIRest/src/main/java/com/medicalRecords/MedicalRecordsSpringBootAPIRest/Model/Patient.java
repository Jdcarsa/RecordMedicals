package com.medicalRecords.MedicalRecordsSpringBootAPIRest.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientId;


    @Column(name = "numId", nullable = false)
    private long numId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "sex", nullable = false)
    @Pattern(regexp = "[FM]")
    private char sex;
    @Column(name = "birthDate", nullable = false)
    private Date birthdate;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "phone", nullable = false)
    private String phone;


    @JsonBackReference
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RecordMedical> recordMedicals = new HashSet<>();

    public Patient(long id,long numId, String name, String lastName, char sex, Date birthdate
            , String address, String phone) {
        this.patientId = id;
        this.numId = numId;
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.birthdate = birthdate;
        this.address = address;
        this.phone = phone;
    }

    public Patient() {
    }

    public long getId() {
        return patientId;
    }

    public void setId(long id) {
        this.patientId = patientId;
    }

    public long getNumId() {
        return numId;
    }

    public void setNumId(long numId) {
        this.numId = numId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Set<RecordMedical> getRecordMedicals() {
        return recordMedicals;
    }

    public void setRecordMedicals(Set<RecordMedical> recordMedicals) {
        this.recordMedicals = recordMedicals;
    }
}
