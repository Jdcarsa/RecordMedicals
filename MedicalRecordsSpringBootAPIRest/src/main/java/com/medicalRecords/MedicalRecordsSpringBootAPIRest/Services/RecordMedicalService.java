package com.medicalRecords.MedicalRecordsSpringBootAPIRest.Services;

import com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO.RecordMedicalDTO;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Model.RecordMedical;

import java.util.List;

public interface RecordMedicalService {

    public RecordMedicalDTO createRecordMedical (Long patientId , RecordMedicalDTO rMDTO);
    public List<RecordMedicalDTO> getRecordMedicalByPatientId(Long patientId);
    public RecordMedicalDTO getRecordMedicalById(Long patientId,Long recordMedicalId);
    public RecordMedicalDTO updateRecordMedical(Long patientId,Long recordMedicalId,RecordMedical updateRM);
    public void deleteRecordMedical(Long patientId,Long recordMedicalId);
}
