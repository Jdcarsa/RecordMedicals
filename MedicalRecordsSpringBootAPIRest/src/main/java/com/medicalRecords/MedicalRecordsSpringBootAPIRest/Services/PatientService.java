package com.medicalRecords.MedicalRecordsSpringBootAPIRest.Services;

import com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO.PatientDTO;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO.ResponsePatients;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Model.Patient;


public interface PatientService {
    /**
     * The createPatient function creates a new patient using the provided patientDTO object.
     * 
     * @param patientDTO The patientDTO parameter is an object of type PatientDTO that contains the
     * information of the patient to be created.
     * @return The createPatient method returns a PatientDTO object.
     */
    public PatientDTO createPatient(PatientDTO patientDTO);

    /**
     * The function returns a response containing a list of patients, with pagination and sorting
     * options.
     * 
     * @param pageNumber The pageNumber parameter is used to specify the page number of the results you
     * want to retrieve. It is typically used in combination with the measurePage parameter to
     * implement pagination and retrieve results in chunks or pages.
     * @param measurePage The measurePage parameter is used to specify the number of patients to be
     * displayed per page.
     * @param sortBy The "sortBy" parameter is used to specify the field by which the patients should
     * be sorted. For example, if "sortBy" is set to "name", the patients will be sorted by their
     * names.
     * @param sortDir The sort direction parameter specifies the direction in which the results should
     * be sorted. It can have two possible values: "asc" for ascending order and "desc" for descending
     * order.
     * @return The method is returning a ResponsePatients object.
     */
    public ResponsePatients findAll(int pageNumber, int measurePage, String sortBy, String sortDir);
    /**
     * The function "getPatientById" retrieves a patient's information based on their ID.
     * 
     * @param patientId The patientId parameter is a Long value that represents the unique identifier
     * of a patient.
     * @return The method is returning a PatientDTO object.
     */
    public PatientDTO getPatientById(Long patientId);
    /**
     * The function updates a patient's information based on the provided patientDTO and patientId.
     * 
     * @param patientDTO A data transfer object (DTO) containing the updated information for the
     * patient.
     * @param patientId The unique identifier for the patient that needs to be updated.
     * @return The method is returning a Patient object.
     */
    public Patient updatePatient(PatientDTO patientDTO, Long patientId);
    /**
     * The deletePatient function deletes a patient with the specified patientId.
     * 
     * @param patientId The patientId parameter is of type Long and represents the unique identifier of
     * the patient that needs to be deleted.
     */
    public void deletePatient(Long patientId);
}

