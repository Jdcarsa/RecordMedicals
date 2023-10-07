package com.medicalRecords.MedicalRecordsSpringBootAPIRest.Model;
import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "RecordsMedical")
public class RecordMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordMedicalId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientId", nullable = false)
    private Patient patient;


    @Column(name = "recordDate", nullable = false)
    private Date recordDate;

    @Lob
    @Column(name = "familyHistory")
    private String familyHistory;

    @Lob
    @Column(name = "personalHistory")
    private String personalHistory;

    @Lob
    @Column(name = "reasonConsult", nullable = false)
    private String reasonConsult;

    @Lob
    @Column(name = "allergies")
    private String allergies;

    @Lob
    @Column(name = "medicinalPrescription")
    private String medicinalPrescription;


    public RecordMedical() {
    }

    public RecordMedical(Patient patient, Date recordDate, String familyHistory,
                         String personalHistory, String reasonConsult,
                         String allergies, String medicinalPrescription) {
        this.patient = patient;
        this.recordDate = recordDate;
        this.familyHistory = familyHistory;
        this.personalHistory = personalHistory;
        this.reasonConsult = reasonConsult;
        this.allergies = allergies;
        this.medicinalPrescription = medicinalPrescription;
    }

    public Long getId() {
        return recordMedicalId;
    }

    public void setRecordMedicalId(long recordMedicalId) {
        this.recordMedicalId = recordMedicalId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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
