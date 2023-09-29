package com.medicalRecords.MedicalRecordsSpringBootAPIRest.Services;

import com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO.PatientDTO;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO.ResponsePatients;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Model.Patient;


public interface PatientService {
    public PatientDTO createPatient(PatientDTO patientDTO);
    public ResponsePatients findAll(int pageNumber, int measurePage, String sortBy, String sortDir);
    public PatientDTO getPatientById(Long patientId);
    public Patient updatePatient(PatientDTO patientDTO, Long patientId);
    public void deletePatient(Long patientId);
}

