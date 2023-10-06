package com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO.RecordMedicalDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PatientDTO {

    private Long id;
    @NotEmpty
    @Size(min = 6,message = "Patient id should have at least 6 digits")
    private Long numId;
    @NotEmpty
    @Size(min = 5,message = "Patient name should have at least 5 characters")
    private String name;
    @NotEmpty
    @Size(min = 5,message = "Patient last name should have at least 5 characters")
    private String lastName;
    @NotEmpty
    @Size(message = "The patient's gender  must be F OR M")
    private char sex;
    @NotEmpty
    private Date birthdate;
    @NotEmpty
    @Size(min = 6,message = "The patient's address should have at least 6 characters")
    private String address;
    @NotEmpty
    @Size(min = 8,message = "The patient's phone should have at least 8 digits")
    private String phone;

    private Set<RecordMedicalDTO> recordMedicals;

    public PatientDTO(Long id , Long numId, String name, String lastName, char sex, Date birthdate
            , String address, String phone) {
        this.id = id;
        this.numId = numId;
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.birthdate = birthdate;
        this.address = address;
        this.phone = phone;
    }

    public PatientDTO() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getNumId() {
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


    public Set<RecordMedicalDTO> getRecordMedicals() {
        return recordMedicals;
    }

    public void setRecordMedicals(Set<RecordMedicalDTO> recordMedicals) {
        this.recordMedicals = recordMedicals;
    }
}
