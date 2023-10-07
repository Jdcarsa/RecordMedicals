package com.medicalRecords.MedicalRecordsSpringBootAPIRest.Services;

import com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO.RecordMedicalDTO;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Model.RecordMedical;

import java.util.List;

public interface RecordMedicalService {

   /**
    * The function creates a medical record for a patient with the given patientId and
    * RecordMedicalDTO.
    * 
    * @param patientId A unique identifier for the patient for whom the medical record is being
    * created.
    * @param rMDTO RecordMedicalDTO is an object that represents the data for a medical record. It
    * contains information such as the date of the record, the type of record, and any relevant notes
    * or details.
    * @return The method is returning a RecordMedicalDTO object.
    */
    public RecordMedicalDTO createRecordMedical (Long patientId , RecordMedicalDTO rMDTO);
    /**
     * The function retrieves a list of medical records for a given patient ID.
     * 
     * @param patientId The patientId parameter is a Long value that represents the unique identifier
     * of a patient.
     * @return The method is returning a List of RecordMedicalDTO objects.
     */
    public List<RecordMedicalDTO> getRecordMedicalByPatientId(Long patientId);
    /**
     * The function "getRecordMedicalById" retrieves a medical record for a specific patient by their
     * ID.
     * 
     * @param patientId The ID of the patient for whom the medical record is being retrieved.
     * @param recordMedicalId The unique identifier of the medical record.
     * @return The method is returning a RecordMedicalDTO object.
     */
    public RecordMedicalDTO getRecordMedicalById(Long patientId,Long recordMedicalId);
    /**
     * The function updates a medical record for a specific patient.
     * 
     * @param patientId The ID of the patient for whom the medical record needs to be updated.
     * @param recordMedicalId The unique identifier of the record medical that needs to be updated.
     * @param updateRM The `updateRM` parameter is an object of type `RecordMedical` that contains the
     * updated information for a medical record.
     * @return The return type of the method is not specified in the given code snippet.
     */
    public RecordMedicalDTO updateRecordMedical(Long patientId,Long recordMedicalId,RecordMedical updateRM);
    /**
     * The function deletes a medical record associated with a specific patient.
     * 
     * @param patientId The ID of the patient whose medical record needs to be deleted.
     * @param recordMedicalId The recordMedicalId parameter is the unique identifier of the medical
     * record that you want to delete.
     */
    public void deleteRecordMedical(Long patientId,Long recordMedicalId);
}
