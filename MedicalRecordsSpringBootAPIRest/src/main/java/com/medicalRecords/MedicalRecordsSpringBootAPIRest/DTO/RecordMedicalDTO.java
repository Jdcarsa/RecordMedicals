package com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO;

import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Model.Patient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class RecordMedicalDTO {


    private Long id;
    @NotNull(message = "Record date can't be empty")
    private Date recordDate;
    private String familyHistory;
    private String personalHistory;
    @NotEmpty(message = "Reason consult can't be empty")
    private String reasonConsult;
    private String allergies;
    private String medicinalPrescription;


    public RecordMedicalDTO() {
    }

    public RecordMedicalDTO(Long id,Date recordDate, String familyHistory,
                            String personalHistory, String reasonConsult,
                            String allergies, String medicinalPrescription) {
        this.id = id;
        this.recordDate = recordDate;
        this.familyHistory = familyHistory;
        this.personalHistory = personalHistory;
        this.reasonConsult = reasonConsult;
        this.allergies = allergies;
        this.medicinalPrescription = medicinalPrescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public String getPersonalHistory() {
        return personalHistory;
    }

    public void setPersonalHistory(String personalHistory) {
        this.personalHistory = personalHistory;
    }

    public String getReasonConsult() {
        return reasonConsult;
    }

    public void setReasonConsult(String reasonConsult) {
        this.reasonConsult = reasonConsult;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedicinalPrescription() {
        return medicinalPrescription;
    }

    public void setMedicinalPrescription(String medicinalPrescription) {
        this.medicinalPrescription = medicinalPrescription;
    }
}
